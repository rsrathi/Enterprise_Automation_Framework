package com.enterprise.driver;

import org.openqa.selenium.WebDriver;


import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;

public class DriverFactory {
	public static final String BROWSER = "browser";
	
	private static final ThreadLocal<WebDriver> DRIVER=new ThreadLocal<WebDriver>();
	
	private DriverFactory() {
		
	}
	public static WebDriver getDriver() {
		if (DRIVER.get()==null) {
			String browser=ConfigReader.getProperty(FrameworkConstants.BROWSER);
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
