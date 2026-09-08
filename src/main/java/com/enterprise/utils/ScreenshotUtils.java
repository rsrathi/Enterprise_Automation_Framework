package com.enterprise.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;

public class ScreenshotUtils {
	private ScreenshotUtils(){}
	public static String captureScreenshot(WebDriver driver, String testName) {
		
		String timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String screenshotPath =ConfigReader.getProperty(FrameworkConstants.SCREENSHOT_PATH);
		Path destination=Paths.get(screenshotPath+testName+"_"+timestamp+".png");
		Path source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE).toPath();
		try {
			Files.createDirectories(Paths.get(screenshotPath));
			Files.copy(source,destination,StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		return destination.toString();
	}

}
