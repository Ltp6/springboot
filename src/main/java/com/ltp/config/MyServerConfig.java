package com.ltp.config;

import com.ltp.filter.MyFilter;
import com.ltp.listener.MyListener;
import com.ltp.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @ClassName MyServerConfig
 * @Auther Ltp
 * @Date 2019/4/24 23:46
 * @Description 注册三大组件的配置类
 * @Version 1.0
 */
@Configuration
public class MyServerConfig {
    /**
     * @Author Ltp
     * @Description 注册Servlet组件
     * @Date 2019/4/24 23:50
     * @Param
     * @return ServletRegistrationBean
     **/
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myservlet");
        //配置启动顺序
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
}
    /**
     * @Author Ltp
     * @Description 注册Filter组件
     * @Date 2019/4/24 23:50
     * @Param
     * @return FilterRegistrationBean
     **/
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return filterRegistrationBean;
    }
    /**
     * @Author Ltp
     * @Description 注册Listener组件
     * @Date 2019/4/24 23:50
     * @Param
     * @return FilterRegistrationBean
     **/
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }
}
