package com.enterprise.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enterprise.base.BasePage;
import com.enterprise.pages.PIMPage;

public class LeftMenuComponent extends BasePage{
	
	public LeftMenuComponent(WebDriver driver) {
		super(driver);
	}

	private final By pimMenu=By.xpath("//span[text()='PIM']");
	
	public PIMPage clickPIM() {

	        click(pimMenu);

	        return new PIMPage(driver);

	    }
	
}
