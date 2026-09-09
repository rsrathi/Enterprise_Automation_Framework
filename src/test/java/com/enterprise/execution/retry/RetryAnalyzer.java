package com.enterprise.execution.retry;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;
import com.enterprise.logger.LoggerManager;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private int retryCount=0;
	private static final Logger LOGGER =LoggerManager.getLogger(RetryAnalyzer.class);
	
	private final int maxRetry=ConfigReader.getInt(FrameworkConstants.RETRY_COUNT);
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(retryCount<maxRetry) {
			retryCount++;
			LOGGER.warn("Retrying test '{}' (Attempt {} of {})",result.getName(),retryCount + 1,maxRetry);
			return true;
		}
		LOGGER.error("Test '{}' failed after {} retries", result.getName(), maxRetry);
		return false;
	}
	
	
}
