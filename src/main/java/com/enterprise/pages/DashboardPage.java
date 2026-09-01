package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.enterprise.base.BasePage;

public class DashboardPage extends BasePage {
private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
public DashboardPage(WebDriver driver) {
	super(driver);
}
public boolean isDashboardDisplayed() {
	return isDisplayed(dashboardHeader);

	 }

	}
