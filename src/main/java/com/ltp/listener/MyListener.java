package com.ltp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName MyListener
 * @Auther Ltp
 * @Date 2019/4/25 00:00
 * @Description 自定义监听器
 * @Version 1.0
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web应用容器初始化了。。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web应用容器销毁了。。。。");
    }
}
