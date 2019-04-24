package com.ltp.config;

import com.ltp.component.LoginHandlerInterceptor;
import com.ltp.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
    /**
     * @return WebMvcConfigurer
     * @Author Ltp
     * @Description 修改SpringMVC部分功能
     * @Date 2019/4/20 23:53
     * @Param
     **/
    //所有的WebMvcConfigurer组件都会起作用
    @Bean//将组件注册到容器中
    public WebMvcConfigurer loginMethod() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            //设置映射关系
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //设置拦截路径，以及排除那些路径
                //SpringBoot针对静态资源，已经做好了静态资源的映射了，不用考虑静态资源的排除问题了
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html", "/index.html", "/", "/user/login");
            }
        };
        return configurer;
    }

    /**
     * @return LocaleResolver
     * @Author Ltp
     * @Description 将国际化组件加入到容器中
     * @Date 2019/4/20 23:52
     * @Param
     **/
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
