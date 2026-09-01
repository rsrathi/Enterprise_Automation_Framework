package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enterprise.base.BasePage;

public class AddEmployeePage extends BasePage {

	public AddEmployeePage(WebDriver driver) {
		super(driver);
		
	}
	
	private final By firstName=By.name("firstName");
	private final By middleName=By.name("middleName");
	private final By lastName=By.name("lastName");
	private final By btnSave=By.xpath("//button[@type='submit']");
	
	public void enterFirstName(String firstname) {
		type(firstName,firstname);
	}
	
	public void enterMiddleName(String middlename) {
		type(middleName,middlename);
	}
	
	public void enterLastName(String lastname) {
		type(lastName,lastname);
	}
	
	public void clickAdd() {
		click(btnSave);
	}
	
	
	
	public EmployeeDetailsPage addEmployee(String firstName,String middleName,String lastName) {
		enterFirstName(firstName);
		enterMiddleName(middleName);
		enterLastName(lastName);
		clickAdd();
		return new EmployeeDetailsPage(driver);
	}
	
	
	

}
