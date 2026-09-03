package com.enterprise.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static final ThreadLocal<WebDriver> DRIVER=new ThreadLocal<WebDriver>();
	
	private DriverFactory() {
		
	}
	public static WebDriver getDriver() {
		if (DRIVER.get()==null) {
			DRIVER.set(new ChromeDriver());
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
