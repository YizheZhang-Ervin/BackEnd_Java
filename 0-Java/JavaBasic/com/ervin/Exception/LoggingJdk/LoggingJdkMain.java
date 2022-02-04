package com.ervin.Exception.LoggingJdk;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class LoggingJdkMain {

	public static void main(String[] args) {
//		Logger logger = Logger.getGlobal();
//		logger.info("start process...");
//		logger.warning("memory is running out...");
//		logger.fine("ignored.");
//		logger.severe("process will be terminated...");
		Logger logger = Logger.getLogger(com.ervin.Exception.ExceptionThrow.ExceptionThrowMain.class.getName());
		logger.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			// TODO: 使用logger.severe()打印异常
		}

		logger.info("Process end.");
	}
}
