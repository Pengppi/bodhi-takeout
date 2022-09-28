/**
 * @Author: Neo
 * @Date: 2022/09/28 星期三 15:14:32
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
