package com.ltp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @PostMapping("user/login")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Model model, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功后防止表单重复提交，利用重定向到dashboard.html
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            session.setAttribute("msg","用户名或密码错误");
            //model.addAttribute("msg", "用户名或密码错误");
            return "redirect:/index.html";
        }

    }

}
