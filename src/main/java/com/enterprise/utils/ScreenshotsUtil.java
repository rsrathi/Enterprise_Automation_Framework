package com.enterprise.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsUtil {
	private ScreenshotsUtil()
	{
		
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		
		String timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String destination="target/screenshots/"+testName+"_"+timestamp+".png";
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.createDirectories(new File("target/screenshots").toPath());
			Files.copy(source.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		return destination;
	}

}
