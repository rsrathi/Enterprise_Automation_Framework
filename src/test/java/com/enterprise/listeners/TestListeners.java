package com.enterprise.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.enterprise.driver.DriverFactory;
import com.enterprise.logger.LoggerManager;
import com.enterprise.reports.AllureManager;
import com.enterprise.utils.ScreenshotsUtil;

public class TestListeners implements ITestListener{
	
	private static final Logger LOGGER = LoggerManager.getLogger(TestListeners.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info("Started: {}",result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info("Passed: {}",result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.info("Failed: {}",result.getMethod().getMethodName());
		String screenshot=ScreenshotsUtil.captureScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
		LOGGER.info("Screenshots saved: {}",screenshot);
		AllureManager.attachScreenshot(screenshot, result.getMethod().getMethodName());
				
	}
	
	
	
	
}
