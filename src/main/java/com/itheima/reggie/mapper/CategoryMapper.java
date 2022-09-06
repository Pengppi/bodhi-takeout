/**
 * @Author: Neo
 * @Date: 2022/08/27 星期六 11:10:07
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
