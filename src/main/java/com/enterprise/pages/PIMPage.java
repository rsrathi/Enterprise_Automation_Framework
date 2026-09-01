package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enterprise.base.BasePage;

public class PIMPage extends BasePage {

	public PIMPage(WebDriver driver) {
		super(driver);
	}
	
	private final By pageHeader = By.xpath("//h6[text()='PIM']");
	private final By btnAdd=By.xpath("//button[normalize-space()='Add']");

    public boolean isPIMPageDisplayed() {

        return isDisplayed(pageHeader);

    }
    
    public AddEmployeePage clickAddEmployee(){

        click(btnAdd);

        return new AddEmployeePage(driver);

    }
    
  

}
