/**
 * @Author: Neo
 * @Date: 2022/09/14 星期三 15:24:33
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.service.SendMailService;
import com.itheima.reggie.service.UserService;
import com.itheima.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userservice;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 发送手机短信验证码
     *
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/sendMsg1")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        //获取手机号
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("验证码:{}", code);
            //调用阿里云提供的短信服务api完成发送短信
            //SMSUtils.sendMessage("吴鹏", "", phone, code);

            //需要将生成的验证码保存到Session
            session.setAttribute(phone, code);
            return R.success("手机验证码短信发送成功");
        }
        return R.error("短信发送失败");
    }


    @PostMapping("/sendMsg")
    public R<String> sendMailMsg(@RequestBody User user, HttpSession session) {
        //获取手机号
        String phone = user.getPhone();
        log.info(phone);
        if (StringUtils.isNotEmpty(phone)) {
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("验证码:{}", code);
            //需要将生成的验证码保存到Session
            session.setAttribute(phone, code);
            //sendMailService.sendLoginCode(phone, code);
            //将生成的验证码缓存刀redis中，并且设置有效期为5分钟
            redisTemplate.opsForValue().set(phone, code, 5, java.util.concurrent.TimeUnit.MINUTES);

            return R.success("邮箱验证码发送成功");
        }
        return R.error("邮箱验证码发送失败");
    }

    /**
     * 移动端用户登录
     *
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        log.info("map:{}", map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();
        //从session中获取保存的验证码
        //Object validateCode = session.getAttribute(phone);

        //从redis中获取缓存的验证码
        String validateCode = redisTemplate.opsForValue().get(phone);


        //比较验证码是否一致（页面提交的验证码和session中保存的验证码比对）
        if (validateCode != null && validateCode.equals(code)) {
            //如果比对成功，说明登录成功
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userservice.getOne(queryWrapper);
            if (user == null) {
                //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userservice.save(user);
            }
            session.setAttribute("user", user.getId());

            //如果登录成功，删除redis中缓存的验证码
            redisTemplate.delete(phone);

            return R.success(user);
        }
        return R.error("登录失败");
    }
}
