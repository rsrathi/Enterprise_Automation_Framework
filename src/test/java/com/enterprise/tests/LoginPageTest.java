package com.enterprise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.enterprise.base.BestTest;
import com.enterprise.pages.AddEmployeePage;
import com.enterprise.pages.DashboardPage;
import com.enterprise.pages.EmployeeDetailsPage;
import com.enterprise.utils.RandomDataUtils;
import com.enterprise.pages.PIMPage;

public class LoginPageTest extends BestTest {
	
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
	
	@Test
	public void verifyAddEmployee() {
		DashboardPage dashboard=loginAsAdmin();
		PIMPage pimPage = dashboard.leftMenu().clickPIM();
		AddEmployeePage addemployee=pimPage.clickAddEmployee();
		EmployeeDetailsPage employee=addemployee.addEmployee(RandomDataUtils.getRandomFirstName(),RandomDataUtils.getRandomMiddleName(),RandomDataUtils.getRandomLastName());
		Assert.assertTrue(employee.isPersonalDetailsDisplayed());
		Assert.assertTrue(employee.isPersonalDetailsDisplayed(),"Employee Details page is not displayed.");
	}

}
