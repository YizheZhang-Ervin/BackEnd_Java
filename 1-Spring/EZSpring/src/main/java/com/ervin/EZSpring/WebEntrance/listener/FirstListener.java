package com.ervin.EZSpring.WebEntrance.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstListener implements ServletContextListener{

    //初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener...init...");
    }

    //销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}