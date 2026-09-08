package com.enterprise.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class BrowserFactory {
	
	private BrowserFactory() {
		
	}
	
	public static WebDriver createBrowser(String browser) {
		switch(browser.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		default:
			throw new IllegalArgumentException("Unsupported Browser:"+browser);
		}
	}

}
