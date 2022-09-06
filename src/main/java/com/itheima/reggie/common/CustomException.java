/**
 * @Author: Neo
 * @Date: 2022/08/27 星期六 14:04:47
 * @Project: reggie
 * @IDE: IntelliJ IDEA
 **/
package com.itheima.reggie.common;

/**
 * 自定义业务异常
 */
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
