package com.enterprise.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
	private static final Properties properties=new Properties();
	
	static {
		try {
			FileInputStream file=new FileInputStream("src/test/resources/config/config.properties");
			properties.load(file);
		}catch(IOException e) {
			throw new RuntimeException("Unable to load config.properties from src/test/resources/config/",e);
		}
	}
	
	private ConfigReader() {
		
	}
	
	public static String getProperty(String key) {
		String value=properties.getProperty(key);
		if(value==null || value.trim().isEmpty()) {
			throw new RuntimeException("Property "+key+"not found in configuration file.");
		}
		return value.trim();
	}
	
	public static boolean getBoolean(String key) {
		return Boolean.getBoolean(getProperty(key));
	}

	public static int getInt(String key) {
	    return Integer.parseInt(getProperty(key));
	}
	
	public static long getLong(String key) {
	    return Long.parseLong(getProperty(key));
	}
}
