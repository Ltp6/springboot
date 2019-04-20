package com.ltp.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @ClassName LoginHandlerInterceptor
 * @Auther Ltp
 * @Date 2019/4/16 00:35
 * @Description 拦截器
 * @Version 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * @Author Ltp
     * @Description 在目标方法执行之前判断是否已登录系统
     * @Date 2019/4/21 0:25
     * @Param request response handler
     * @return boolean
     **/
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            //未登录
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            //已登录，放行
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
