package com.ltp.controller;

import com.ltp.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExceptionHandlerDemo
 * @Auther Ltp
 * @Date 2019/4/24 00:12
 * @Description 异常处理器
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionHandlerDemo {
    //没有自适应效果，浏览器客户端都显示Json数据
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("status",9527);
        map.put("message",e.getMessage());
        map.put("exception",e.toString());
        return map;
    }*/
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        /*
        * 传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        * Integer statusCode = (Integer) request
        *		.getAttribute("javax.servlet.error.status_code");
        * */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("status",9527);
        map.put("message",e.getMessage());
        map.put("exception",e.toString());
        //放入请求域中
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
