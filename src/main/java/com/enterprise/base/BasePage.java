package com.enterprise.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.enterprise.utils.WaitUtils;

public class BasePage {

	protected WebDriver driver;
	protected final WaitUtils waitUtils;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils=new WaitUtils(driver);
	}
	
	protected void type(By locator,String text) {
		WebElement element=find(locator);
		element.click();
		element.sendKeys(text);
	}
	protected void waitForLoaderToDisappear(By loader) {
		waitUtils.waitForInvisibility(loader);
	}
	
	protected void click(By locator) {
		find(locator).click();
		}
	
	protected String getText(By locator) {
		return find(locator).getText();
	}
	
	protected boolean isDisplayed(By locator) {
		return find(locator).isDisplayed();
	}
	
	protected WebElement find(By locator) {
	    return waitUtils.waitForVisibility(locator);

	}
	protected void selectAutoSuggestion(String option) {
		By suggestion=By.xpath("//span[text()='"+option+"']");
		waitUtils.waitForVisibility(suggestion);
		click(suggestion);
	}
	
	protected boolean isElementPresent(By locator) {

	    return !driver.findElements(locator).isEmpty();

	}
}
