package com.ltp.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MyConfig
 * @Auther Ltp
 * @Date 2019/4/16 00:18
 * @Description SpringMVC 配置类过时
 * @Version 1.0
 */
//@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/ltp").setViewName("success");
    }*/
}
