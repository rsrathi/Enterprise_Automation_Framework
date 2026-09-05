package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enterprise.base.BasePage;
import com.enterprise.components.LeftMenuComponent;

public class EmployeeDetailsPage extends BasePage {
	

    private By personalDetailsHeader =By.xpath("//h6[text()='Personal Details']");
    private final LeftMenuComponent leftMenu;

	public EmployeeDetailsPage(WebDriver driver) {
		
		super(driver);
		leftMenu = new LeftMenuComponent(driver);
		
		
	}
	
	  public boolean isPersonalDetailsDisplayed() {

	        return isDisplayed(personalDetailsHeader);

	    }

	  public LeftMenuComponent leftMenu() {
	      return leftMenu;
	  }
	
}
