package com.enterprise.pages;
import org.apache.logging.log4j.Logger;
import com.enterprise.logger.LoggerManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enterprise.base.BasePage;

public class LoginPage extends BasePage{
	
	private static final Logger LOGGER =
	        LoggerManager.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private final By txtUsername=By.name("username");
	private final By txtPassword=By.name("password");
	private final By btnLogin=By.cssSelector("button[type='submit']");
	
	public void enterUsername(String username) {
		LOGGER.info("Entering Username");
		type(txtUsername,username);
	}
	
	public void enterPassword(String password) {
		LOGGER.info("Entering Password");
		type(txtPassword,password);
		
	}
	
	public void clickLogin() {
		LOGGER.info("Clicking Login");
		click(btnLogin);
	}
	
	public DashboardPage login(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
		return new DashboardPage(driver);
	}
}
