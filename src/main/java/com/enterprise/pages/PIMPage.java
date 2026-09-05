package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.enterprise.base.BasePage;
import org.apache.logging.log4j.Logger;
import com.enterprise.logger.LoggerManager;
import com.enterprise.models.Employee;

public class PIMPage extends BasePage {

	public PIMPage(WebDriver driver) {
		super(driver);
	}
	private static final Logger LOGGER =LoggerManager.getLogger(PIMPage.class);
	private final By pageHeader = By.xpath("//h6[text()='PIM']");
	private final By btnAdd=By.xpath("//button[normalize-space()='Add']");
	private final By txtEmployeeName=By.xpath("//input[@placeholder='Type for hints...']");
	private final By btnSearch=By.xpath("//button[@type='submit']");
	private final By btnReset=By.xpath("//button[@type='Reset']");

    public boolean isPIMPageDisplayed() {

        return isDisplayed(pageHeader);

    }
    
    public AddEmployeePage clickAddEmployee(){
        LOGGER.info("Navigating to Add Employee page.");
        click(btnAdd);
        return new AddEmployeePage(driver);

    }
    
    public PIMPage searchEmployee(Employee employeeName) {
    	LOGGER.info("Searching Employee: {}",employeeName.getFullName());
    	type(txtEmployeeName,employeeName.getFullName());
    	selectAutoSuggestion(employeeName.getFullName());
    	click(btnSearch);
    	return this;
    }
    
    public boolean isEmployeeDisplayed(Employee employeeName) {
    	By employeeLocator=By.xpath("//div[normalize-space()='"+employeeName.getFirstName()+" "+employeeName.getMiddleName()+"']");
    	return isDisplayed(employeeLocator);
    }

}
