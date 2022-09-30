/**
 * @Author: Neo
 * @Date: 2022/09/30 星期五 23:22:34
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
