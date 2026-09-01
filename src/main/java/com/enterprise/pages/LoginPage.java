package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enterprise.base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private final By txtUsername=By.name("username");
	private final By txtPassword=By.name("password");
	private final By btnLogin=By.cssSelector("button[type='submit']");
	
	public void enterUsername(String username) {
		type(txtUsername,username);
	}
	
	public void enterPassword(String password) {
		type(txtPassword,password);
	}
	
	public void clickLogin() {
		click(btnLogin);
	}
	
	public DashboardPage login(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
		return new DashboardPage(driver);
	}
}
