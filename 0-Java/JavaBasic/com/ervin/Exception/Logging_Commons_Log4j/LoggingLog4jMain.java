package com.ervin.Exception.Logging_Commons_Log4j;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingLog4jMain {

	static final Log log = LogFactory.getLog(com.ervin.Exception.ExceptionThrow.ExceptionThrowMain.class);

	public static void main(String[] args) {
		log.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			log.error("Invalid encoding.", e);
		}
		log.info("Process end.");
	}
}
