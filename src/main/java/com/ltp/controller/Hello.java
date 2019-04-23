package com.ltp.controller;

import com.ltp.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
@Controller
public class Hello {
    @ResponseBody
    @RequestMapping(value = "/hello")
    public String helloMethod(@RequestParam(value = "user") String user){
        if(user.equals("ltp")){
            throw  new UserNotExistException();
        }
        return "hello world!!";
    }
    @RequestMapping(value = "/success")
    public String success(Map<String,String> map){
        map.put("hello","你好");
        return "success";
    }
}
