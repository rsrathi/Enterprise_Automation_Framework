package com.enterprise.services;

import org.openqa.selenium.WebDriver;

import com.enterprise.models.Employee;
import com.enterprise.pages.AddEmployeePage;
import com.enterprise.pages.EmployeeDetailsPage;
import com.enterprise.pages.PIMPage;

public class EmployeeService {
	private final WebDriver driver;
	public EmployeeService(WebDriver driver) {
		this.driver=driver;
	}
	
	public EmployeeDetailsPage createEmployee(PIMPage pim,Employee employee) {
		AddEmployeePage add=pim.clickAddEmployee();
		return add.addEmployee(employee);
	}
	
	public boolean searchEmployee(PIMPage pim,Employee employee) {
		pim.searchEmployee(employee);
		return pim.isEmployeeDisplayed(employee);
	}

}
