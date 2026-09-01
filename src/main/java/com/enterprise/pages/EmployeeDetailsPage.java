package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enterprise.base.BasePage;

public class EmployeeDetailsPage extends BasePage {
	

    private By personalDetailsHeader =By.xpath("//h6[text()='Personal Details']");

	public EmployeeDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	  public boolean isPersonalDetailsDisplayed() {

	        return isDisplayed(personalDetailsHeader);

	    }


	
}
