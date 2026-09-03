package com.enterprise.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.enterprise.config.ConfigReader;
import com.enterprise.driver.DriverFactory;
import com.enterprise.logger.LoggerManager;
import com.enterprise.pages.DashboardPage;
import com.enterprise.pages.LoginPage;

public class BestTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		LOGGER.info("Launching browser...");
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("application.url"));
		LOGGER.info("Opening application URL.");
	
	}
	
	protected DashboardPage loginAsAdmin() {
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
	}
	
	private static final Logger LOGGER=LoggerManager.getLogger(BestTest.class);
	
	@AfterMethod
	public void tearDown()
	{
		DriverFactory.quitDriver();
		LOGGER.info("Closing browser.");
	}

}
