package com.enterprise.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConfigReader {
	private static final Properties properties=new Properties();
	
	static {
		try {
			FileInputStream file=new FileInputStream("src/test/resources/config/config.properties");
			properties.load(file);
		}catch(IOException e) {
			throw new RuntimeException("Unable to load configuration file",e);
		}
	}
	
	private ConfigReader() {
		
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
