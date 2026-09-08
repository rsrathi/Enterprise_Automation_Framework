package com.enterprise.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
	private final JavascriptExecutor jsExecutor;

    public JavaScriptUtils(WebDriver driver) {
        this.jsExecutor = (JavascriptExecutor) driver;
    }
    
    public void click(WebElement element) {
    	jsExecutor.executeScript("arguments[0].click();", element);
    }
    
    public void scrollIntoView(WebElement element) {
    	jsExecutor.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
    
    public void scrollToBottom() {
    	jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public void scrollToTop() {
    	jsExecutor.executeScript("window.scrollTo(0,0);");
    }
    
    public void highlightElement(WebElement element) {
    	jsExecutor.executeScript("arguments[0].style.border='3px solid red';",element);
    }
}
