package com.enterprise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.enterprise.base.BaseTest;
import com.enterprise.pages.DashboardPage;


public class LoginPageTest extends BaseTest {
	
	@Test
	public void verifyLogin() {
		DashboardPage dashboard=loginAsAdmin();
		Assert.assertTrue(dashboard.isDashboardDisplayed());
	}
	
	
}
