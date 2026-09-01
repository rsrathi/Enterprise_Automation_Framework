package com.enterprise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.enterprise.base.BasePage;
import com.enterprise.components.LeftMenuComponent;

public class DashboardPage extends BasePage {
	private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	private final LeftMenuComponent leftMenu;

	public DashboardPage(WebDriver driver) {
		super(driver);
		leftMenu = new LeftMenuComponent(driver);
	}

	public boolean isDashboardDisplayed() {
		return isDisplayed(dashboardHeader);

	}

	public LeftMenuComponent leftMenu() {

		return leftMenu;

	}
}
