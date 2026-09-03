package com.enterprise.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.enterprise.base.BasePage;
import com.enterprise.components.LeftMenuComponent;
import com.enterprise.logger.LoggerManager;

public class DashboardPage extends BasePage {
	private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	private final LeftMenuComponent leftMenu;
	private static final Logger LOGGER = LoggerManager.getLogger(DashboardPage.class);

	public DashboardPage(WebDriver driver) {
		super(driver);
		leftMenu = new LeftMenuComponent(driver);
	}

	public boolean isDashboardDisplayed() {
		boolean displayed = isDisplayed(dashboardHeader);

	    LOGGER.info("Dashboard visibility status: {}", displayed);

	    return displayed;

	}

	public LeftMenuComponent leftMenu() {
		return leftMenu;

	}
}
