package com.ltp.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Auther Ltp
 * @Date 2019/4/24 23:54
 * @Description filter
 * @Version 1.0
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process ......");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
