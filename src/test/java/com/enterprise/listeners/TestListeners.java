package com.enterprise.listeners;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;
import com.enterprise.driver.DriverFactory;
import com.enterprise.logger.LoggerManager;
import com.enterprise.reports.AllureManager;
import com.enterprise.utils.ScreenshotUtils;
import org.testng.ITestContext;
import com.enterprise.reports.ExtentManager;
import com.enterprise.reports.ExtentTestManager;

public class TestListeners implements ITestListener{
	
	private static final Logger LOGGER = LoggerManager.getLogger(TestListeners.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info("Started: {}",result.getMethod().getMethodName());
		try {
			ExtentTestManager.setTest(ExtentManager.getInstance().createTest(result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.getTest().assignCategory("Regression");
		ExtentTestManager.getTest().assignAuthor("Roshani Rathi");
		ExtentTestManager.getTest().assignDevice(ConfigReader.getProperty(FrameworkConstants.BROWSER));
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info("Passed: {}",result.getMethod().getMethodName());
		ExtentTestManager.getTest().pass("Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.info("Failed: {}",result.getMethod().getMethodName());
		String screenshot=ScreenshotUtils.captureScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
		LOGGER.info("Screenshots saved: {}",screenshot);
		ExtentTestManager.getTest().fail(result.getThrowable());
		try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);
		}catch(Exception e) {
			LOGGER.error("Unable to attach screenshot to Extent report", e);
		}
		AllureManager.attachScreenshot(screenshot, result.getMethod().getMethodName());
				
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.warn("Skipped: {}", result.getMethod().getMethodName());
		ExtentTestManager.getTest().skip("Test Skipped");
	}
	

	@Override
	public void onFinish(ITestContext context) {
		try {
			ExtentManager.getInstance().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.unload();
	}
	
	
	
}
