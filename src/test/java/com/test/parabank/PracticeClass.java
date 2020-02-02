package com.test.parabank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PracticeClass {

	public static Logger log = LogManager.getLogger();
	public static void main(String[] args) throws InterruptedException {
		log.error("this is debug");
		log.info("this is info");
		log.fatal("this is fatal");
		log.warn("this is warn");
		System.out.print("Done");
		

	}

}
