/**
 * @Author: Neo
 * @Date: 2022/09/30 星期五 23:23:23
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Orders;


public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     *
     * @param orders
     */
    void submit(Orders orders);
}
