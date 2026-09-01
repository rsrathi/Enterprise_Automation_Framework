package com.enterprise.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.enterprise.config.ConfigReader;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("explicit.wait"))));
	}
	
	protected void type(By locator,String text) {
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	protected void click(By locator) {
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		}
	
	protected String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	protected boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
}
