package com.ervin.Exception.Logging_Slf4j_Logback;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingSlf4jMain {

	static final Logger logger = LoggerFactory.getLogger(com.ervin.Exception.ExceptionThrow.ExceptionThrowMain.class);

	public static void main(String[] args) {
		logger.info("Start process {}...", com.ervin.Exception.ExceptionThrow.ExceptionThrowMain.class.getName());
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			// TODO: 使用logger.error(String, Throwable)打印异常
		}
		logger.info("Process end.");
	}
}
