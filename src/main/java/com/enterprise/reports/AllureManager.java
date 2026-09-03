package com.enterprise.reports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.qameta.allure.Allure;

public class AllureManager {
	private AllureManager() {
		
	}

	public static void attachScreenshot(String screenshotPath, String attachmentName) {
		try {
			Allure.addAttachment(attachmentName,Files.newInputStream(Paths.get(screenshotPath)));
		}catch(IOException e) {
			throw new RuntimeException("Unable to attach screenshot to Allure",e);
		}
	}
}
