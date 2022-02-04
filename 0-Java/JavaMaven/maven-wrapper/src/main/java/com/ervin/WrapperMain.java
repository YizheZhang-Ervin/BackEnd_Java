package com.ervin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WrapperMain {

	public static void main(String[] args) throws Exception {
		Logger logger = LoggerFactory.getLogger(WrapperMain.class);
		logger.info("start application...");
		for (int i = 1; i <= 10; i++) {
			Thread.sleep(100);
			logger.warn("begin task {}...", i);
		}
		logger.info("done.");
	}
}
