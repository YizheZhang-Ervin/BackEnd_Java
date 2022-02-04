package com.ervin.Exception.LoggingCommons;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingCommonsMain {

	static final Log log = LogFactory.getLog(com.ervin.Exception.ExceptionThrow.ExceptionThrowMain.class);

	public static void main(String[] args) {
		log.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			// TODO: 使用log.error(String, Throwable)打印异常
			log.error("Exception", e);
		}
		log.info("Process end.");
	}
}
