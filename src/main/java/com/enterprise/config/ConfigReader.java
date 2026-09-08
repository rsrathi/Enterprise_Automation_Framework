package com.enterprise.config;
import java.util.Properties;

public class ConfigReader {
	private static final Properties frameworkProperties=new Properties();
	private static final Properties environmentProperties = new Properties();
	
	static {
		frameworkProperties.putAll(PropertyLoader.load("src/test/resources/config/framework.properties"));

		    String environment =EnvironmentManger.getEnvironment(frameworkProperties);

		    environmentProperties.putAll(PropertyLoader.load("src/test/resources/config/" +environment +".properties"));
	}
	
	private ConfigReader() {
		
	}
	
	public static String getProperty(String key) {
		String value=System.getProperty(key);
		if(value==null || value.trim().isEmpty()) {
			return value.trim();
		}
		value =environmentProperties.getProperty(key);
		 if (value != null && !value.isBlank()) {
		        return value.trim();
		    }

		    value = frameworkProperties.getProperty(key);

		    if (value != null && !value.isBlank()) {
		        return value.trim();
		    }

		    throw new RuntimeException(
		            "Property '" + key + "' not found.");
	}
	public static boolean getBoolean(String key) {
		return Boolean.parseBoolean(getProperty(key));
	}

	public static int getInt(String key) {
	    return Integer.parseInt(getProperty(key));
	}
	
	public static long getLong(String key) {
	    return Long.parseLong(getProperty(key));
	}
}
