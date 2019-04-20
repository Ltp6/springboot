package com.ltp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
/**
 * @ClassName LoginController
 * @Auther Ltp
 * @Date 2019/4/16 00:35
 * @Description 登录控制器
 * @Version 1.0
 */
@Controller
public class LoginController {
    /**
     * @Author Ltp
     * @Description 登录方法
     * @Date 2019/4/21 0:18
     * @Param username(用户名) password(密码) session redirectAttributes
     * @return String
     **/
    @PostMapping("/user/login")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpSession session,RedirectAttributes redirectAttributes) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功后防止表单重复提交，利用重定向到dashboard.html
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            //RedirectAttributes为重定向时传递参数的方法，会自动在浏览器URL上拼接数据
            //前台取值采用<p style="color: red" th:text="${param.msg[0]}" th:unless="${param.msg == null}"></p>
            redirectAttributes.addAttribute("msg", "用户名或密码错误");
            return "redirect:/index.html";
        }

    }

}
