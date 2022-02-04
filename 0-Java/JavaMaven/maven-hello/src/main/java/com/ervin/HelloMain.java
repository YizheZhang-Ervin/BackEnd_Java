package com.ervin;

import org.slf4j.LoggerFactory;

public class HelloMain {

	public static void main(String[] args) throws Exception {
		var logger = LoggerFactory.getLogger(HelloMain.class);
		logger.info("start application...");
		for (int i = 1; i <= 10; i++) {
			Thread.sleep(100);
			logger.warn("begin task {}...", i);
		}
		logger.info("done.");
	}
}
