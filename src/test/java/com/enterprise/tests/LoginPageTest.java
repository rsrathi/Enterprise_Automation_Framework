package com.enterprise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.enterprise.base.BestTest;
import com.enterprise.config.ConfigReader;
import com.enterprise.pages.DashboardPage;
import com.enterprise.pages.LoginPage;
import com.enterprise.pages.PIMPage;

public class LoginPageTest extends BestTest {
	protected DashboardPage loginAsAdmin() {

	    LoginPage loginPage = new LoginPage(driver);

	    return loginPage.login(
	            ConfigReader.getProperty("username"),
	            ConfigReader.getProperty("password"));
	}
	
	@Test
	public void verifyLogin() {
		DashboardPage dashboard=loginAsAdmin();
		Assert.assertTrue(dashboard.isDashboardDisplayed());
	}
	
	@Test
	public void verifyNavigationToPIM() {
		DashboardPage dashboard=loginAsAdmin();
		PIMPage pimPage=dashboard.leftMenu().clickPIM();
		Assert.assertTrue(pimPage.isPIMPageDisplayed());
	}

}
