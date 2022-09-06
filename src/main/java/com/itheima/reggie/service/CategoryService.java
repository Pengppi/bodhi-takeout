/**
 * @Author: Neo
 * @Date: 2022/08/25 星期四 15:41:21
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

public interface CategoryService extends IService<Category> {

    void remove(Long id);
}
