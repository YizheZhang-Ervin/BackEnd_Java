package com.ervin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Autowired
	private MyConfig myConfig;

	@Autowired
	private DummyConfig dummyConfig;

	@Scheduled(fixedDelay = 5000)
	public void hello() {
		System.out.println("The first message is: " + this.myConfig.getMessage());
		System.out.println("The other message is: " + this.dummyConfig.getMessage());
	}

}
