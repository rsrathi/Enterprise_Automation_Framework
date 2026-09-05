package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.enterprise.base.BasePage;
import com.enterprise.models.Employee;

public class AddEmployeePage extends BasePage {

	public AddEmployeePage(WebDriver driver) {
		super(driver);
		
	}
	
	private final By firstName=By.name("firstName");
	private final By middleName=By.name("middleName");
	private final By lastName=By.name("lastName");
	private final By btnSave=By.xpath("//button[@type='submit']");
	private final By loader=By.xpath("//div[@class='oxd-form-loader']");
	private final By personalDetailsHeader =By.xpath("//h6[text()='Personal Details']");
	private final By employeeID=By.xpath("//input[@class='oxd-input oxd-input--active']");
	
	public void enterFirstName(String firstname) {
		type(firstName,firstname);
	}
	
	public void enterMiddleName(String middlename) {
		type(middleName,middlename);
	}
	
	public void enterLastName(String lastname) {
		type(lastName,lastname);
	}
	
	public void clickSave() {
		click(btnSave);
	}
	
	public void enterEmployeeId(String id) {
		type(employeeID,id);
	}
	
	
	public EmployeeDetailsPage addEmployee(Employee employee) {
		enterFirstName(employee.getFirstName());
		enterMiddleName(employee.getMiddleName());
		enterLastName(employee.getLastName());
		enterEmployeeId(employee.getEmployeeID());
		clickSave();
		wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader));
		return new EmployeeDetailsPage(driver);
	}
	
	
	

}
