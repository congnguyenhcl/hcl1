package com.hcl.cong.log4j1;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class App {
	static Logger log = Logger.getLogger(App.class.getName());

	public static void main(String[] args) throws IOException, SQLException {
//		PropertyConfigurator
//				.configure("C:\\Users\\fry\\Dropbox\\coding_problems\\Maven\\log4j1\\src\\main\\resources\\log4j.properties");
		log.debug("Sample debug message");
		log.info("Sample info message");
		log.warn("Sample warn message");
		log.error("Sample error message");
		log.fatal("Sample fatal message");
		System.out.println("Done");

	}
}