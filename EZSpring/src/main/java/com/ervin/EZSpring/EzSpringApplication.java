package com.ervin.EZSpring;

import com.ervin.EZSpring.WebEntrance.listener.FirstListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.EventListener;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = xx.class)  // 启动自动配置，但排除指定的自动配置
//@Import({ xx.class, yy.class})
//@ServletComponentScan()  // listener注册方式1
@EnableCaching
@MapperScan("com.ervin.EZSpring.WebEntrance.dao") //扫描的mapper
public class EzSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzSpringApplication.class, args);
	}

	/**
	 * listener注册方式2
	 */
//	@Bean
//	public ServletListenerRegistrationBean<EventListener> getServletListenerRegistrationBean(){
//		ServletListenerRegistrationBean<EventListener> bean =new ServletListenerRegistrationBean<EventListener>(new FirstListener()Listener());
//		return bean;
//	}

}
