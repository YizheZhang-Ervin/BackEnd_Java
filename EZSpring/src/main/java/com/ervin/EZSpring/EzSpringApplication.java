package com.ervin.EZSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = xx.class)  // 启动自动配置，但排除指定的自动配置
//@Import({ xx.class, yy.class})
public class EzSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzSpringApplication.class, args);
	}

}
