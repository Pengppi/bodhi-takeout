/**
 * @Author: Neo
 * @Date: 2022/09/30 星期五 23:25:02
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.controller;

import com.itheima.reggie.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;
}
