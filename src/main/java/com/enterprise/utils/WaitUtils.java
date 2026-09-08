package com.enterprise.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;

public class WaitUtils {
	
	private final WebDriverWait wait;
	
	public WaitUtils(WebDriver driver) {
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt(FrameworkConstants.EXPLICIT_WAIT)));
	}
	
	public WebElement waitForVisibility(By Locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	
	public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
