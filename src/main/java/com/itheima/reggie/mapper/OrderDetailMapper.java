/**
 * @Author: Neo
 * @Date: 2022/09/30 星期五 23:23:04
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}
