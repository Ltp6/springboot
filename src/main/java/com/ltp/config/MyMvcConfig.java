package com.ltp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyMvcConfig
 * @Auther Ltp
 * @Date 2019/4/16 00:35
 * @Description SpringMVC配置类
 * @Version 1.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ltp").setViewName("success");
    }
}
