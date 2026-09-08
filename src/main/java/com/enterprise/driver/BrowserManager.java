package com.enterprise.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.enterprise.config.ConfigReader;

public final class BrowserManager {
	private BrowserManager() {}
		public static ChromeOptions getChromeOptions() {
			 ChromeOptions options = new ChromeOptions();

		        if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
		            options.addArguments("--headless=new");
		        }

		        if(Boolean.parseBoolean(ConfigReader.getProperty("incognito"))) {
		            options.addArguments("--incognito");
		        }

		        if(Boolean.parseBoolean(ConfigReader.getProperty("maximize"))) {
		            options.addArguments("--start-maximized");
		        }

		        if(Boolean.parseBoolean(ConfigReader.getProperty("disableNotifications"))) {
		            options.addArguments("--disable-notifications");
		        }

		        options.setAcceptInsecureCerts(
		                Boolean.parseBoolean(
		                        ConfigReader.getProperty("acceptInsecureCerts")));

		        return options;
		    }
		public static FirefoxOptions getFirefoxOptions() {

	        FirefoxOptions options = new FirefoxOptions();

	        if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
	            options.addArguments("-headless");
	        }

	        options.setAcceptInsecureCerts(
	                Boolean.parseBoolean(
	                        ConfigReader.getProperty("acceptInsecureCerts")));

	        return options;
	    }
		public static EdgeOptions getEdgeOptions() {

	        EdgeOptions options = new EdgeOptions();

	        if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
	            options.addArguments("--headless=new");
	        }

	        options.setAcceptInsecureCerts(
	                Boolean.parseBoolean(
	                        ConfigReader.getProperty("acceptInsecureCerts")));

	        return options;
	    }
}

