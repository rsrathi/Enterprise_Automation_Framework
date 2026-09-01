package com.enterprise.base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.enterprise.config.ConfigReader;
import com.enterprise.driver.DriverFactory;

public class BestTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("application.url"));
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		DriverFactory.quitDriver();
	}

}
