package com.enterprise.driver;

import org.openqa.selenium.WebDriver;


import com.enterprise.config.ConfigReader;

public class DriverFactory {
	
	private static final ThreadLocal<WebDriver> DRIVER=new ThreadLocal<WebDriver>();
	
	private DriverFactory() {
		
	}
	public static WebDriver getDriver() {
		if (DRIVER.get()==null) {
			String browser=ConfigReader.getProperty("browser");
			DRIVER.set(BrowserFactory.createBrowser(browser));
		}
		return DRIVER.get();
	}
	
	public static void quitDriver() {
		if(DRIVER.get()!=null) {
			DRIVER.get().quit();
			DRIVER.remove();
		}
		
	}

}
