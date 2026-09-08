package com.enterprise.config;

import java.io.FileInputStream;
import java.util.Properties;

import com.enterprise.exception.ConfigurationException;

public final class PropertyLoader {
	private PropertyLoader() {
		
	}
	
	public static Properties load(String filePath) {
		Properties properties=new Properties();
		try (FileInputStream file = new FileInputStream(filePath)) {
			properties.load(file);
		}catch (Exception e) {
			throw new ConfigurationException("Unable to load property file: " + filePath,e);
		}
		return properties;
	}

}
