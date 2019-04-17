package com.ltp.config;

import com.ltp.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
//使SpringMVC的自动配置文件失效
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ltp").setViewName("login");
    }
    //所有的WebMvcConfigurer组件都会起作用
    @Bean//将组件注册到容器中
    public WebMvcConfigurer loginMethod(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
            }
        };
        return configurer;
    }
    @Bean
    public LocaleResolver localeResolverMethod(){
        return new MyLocaleResolver();
    }
}
