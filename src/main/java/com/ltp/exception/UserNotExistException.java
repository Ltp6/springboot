package com.ltp.exception;

/**
 * @ClassName UserNotExistException
 * @Auther Ltp
 * @Date 2019/4/23 23:57
 * @Description 自定义用户不存在异常
 * @Version 1.0
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("用户不存在");
    }
}
