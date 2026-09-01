package com.enterprise.tests;

import org.testng.annotations.Test;

import com.enterprise.base.BestTest;
import com.enterprise.config.ConfigReader;
import com.enterprise.pages.LoginPage;

public class LoginPageTest extends BestTest {
	@Test
	public void verifyLogin() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	}

}
