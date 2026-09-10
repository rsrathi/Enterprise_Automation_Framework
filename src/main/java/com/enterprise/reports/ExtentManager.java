package com.enterprise.reports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;

public class ExtentManager {
	private static ExtentReports extent;
	private ExtentManager() {}
	public static synchronized ExtentReports getInstance() throws IOException {
		if(extent==null) {
			String timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String reportFolder=ConfigReader.getProperty(FrameworkConstants.REPORT_PATH);
			Files.createDirectories(Paths.get(reportFolder));
			Path reportPath=Paths.get(reportFolder,"ExtentReport_"+timestamp+".html");
			ExtentSparkReporter spark=new ExtentSparkReporter(reportPath.toString());
			spark.config().setDocumentTitle("Enterprise Automation Report");
			spark.config().setReportName("Regression Automation Report");
			extent=new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Framework", "Enterprise Selenium Framework");
			extent.setSystemInfo("Tester", "Roshani Rathi");
			extent.setSystemInfo("Enviornment", ConfigReader.getProperty(FrameworkConstants.BROWSER));
		}
		return extent;
	}

}
