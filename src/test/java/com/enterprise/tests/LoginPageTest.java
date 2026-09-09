package com.enterprise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.enterprise.base.BaseTest;
import com.enterprise.pages.DashboardPage;
import com.enterprise.execution.retry.RetryAnalyzer;


public class LoginPageTest extends BaseTest {
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyLogin() {
		DashboardPage dashboard=loginAsAdmin();
		Assert.assertTrue(dashboard.isDashboardDisplayed());
		//Assert.fail("Testing retry Framewrok");
	}
	
	
}
