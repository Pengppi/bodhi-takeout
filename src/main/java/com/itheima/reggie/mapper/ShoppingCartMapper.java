/**
 * @Author: Neo
 * @Date: 2022/09/30 星期五 22:04:13
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

}
