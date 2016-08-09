package com.gdut.test.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


public class LogTest {
	
	Log log = LogFactory.getLog(getClass());
	@Test
	public void TestLog(){
		try {
			int i = 1/0;
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
		}
		log.info("这是info");
		log.debug("这是debug");
		/*log.warn("warn1");*/
	/*	log.error("这是error1");
		log.fatal("这是fatal1");*/
	}
}
