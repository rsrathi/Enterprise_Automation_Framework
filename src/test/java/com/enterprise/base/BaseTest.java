package com.enterprise.base;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;

import com.enterprise.listeners.TestListeners;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;
import com.enterprise.driver.DriverFactory;
import com.enterprise.logger.LoggerManager;
import com.enterprise.pages.DashboardPage;
import com.enterprise.pages.LoginPage;
import com.enterprise.pages.PIMPage;


@Listeners(TestListeners.class)
public class BaseTest {
	protected WebDriver driver;
	
	private static final Logger LOGGER=LoggerManager.getLogger(BaseTest.class);
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		LOGGER.info("Launching browser...");
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty(FrameworkConstants.APPLICATION_URL));
		LOGGER.info("Opening application URL.");
	
	}
	
	protected DashboardPage loginAsAdmin() {
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.login(ConfigReader.getProperty(FrameworkConstants.USERNAME),ConfigReader.getProperty(FrameworkConstants.PASSWORD));
	}
	
	protected PIMPage navigateToPIM() {

	    DashboardPage dashboard =loginAsAdmin();
	    return dashboard.leftMenu().clickPIM();
	}
	
	@AfterMethod
	public void tearDown()
	{
		DriverFactory.quitDriver();
		LOGGER.info("Closing browser.");
	}

}
