package com.enterprise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.enterprise.base.BestTest;
import com.enterprise.models.Employee;
import com.enterprise.pages.AddEmployeePage;
import com.enterprise.pages.EmployeeDetailsPage;
import com.enterprise.pages.PIMPage;
import com.enterprise.services.EmployeeService;
import com.enterprise.utils.RandomDataUtils;

public class PIMPageTest extends BestTest {
	@Test
	public void verifyNavigationToPIM() {
		PIMPage pim=navigateToPIM();
		Assert.assertTrue(pim.isPIMPageDisplayed());
	}
	
	@Test
	public void verifyAddEmployee() {
		PIMPage pim =navigateToPIM();
		Employee employee=RandomDataUtils.getRandomEmployee();
		EmployeeService service=new EmployeeService(driver);
		EmployeeDetailsPage employeedetails=service.createEmployee(pim, employee);
		Assert.assertTrue(employeedetails.isPersonalDetailsDisplayed(),"Employee Details page is not displayed.");
	}

	@Test
	public void shouldSearchEmployeeSuccessfully() {
		PIMPage pim=navigateToPIM();
		Employee employee=RandomDataUtils.getRandomEmployee();
		EmployeeService service=new EmployeeService(driver);
		service.createEmployee(pim, employee);
		EmployeeDetailsPage details=new EmployeeDetailsPage(driver);
		PIMPage searchPage =details.leftMenu().clickPIM();
		//Assert.assertTrue(searchPage.searchEmployee(employee));
	}
}
