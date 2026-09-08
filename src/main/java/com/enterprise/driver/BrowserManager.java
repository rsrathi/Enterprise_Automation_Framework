package com.enterprise.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.enterprise.config.ConfigReader;

public final class BrowserManager {
	private BrowserManager() {
	}

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();

		if (ConfigReader.getBoolean("headless")) {
			options.addArguments("--headless=new");
		}
		if (ConfigReader.getBoolean("incognito")) {
		    options.addArguments("--incognito");
		}
		if (ConfigReader.getBoolean("disableNotifications")) {
		    options.addArguments("--disable-notifications");
		}

		options.setAcceptInsecureCerts(ConfigReader.getBoolean("acceptInsecureCerts"));

		return options;
	}

	public static FirefoxOptions getFirefoxOptions() {

		FirefoxOptions options = new FirefoxOptions();

		if (ConfigReader.getBoolean("headless")) {
		    options.addArguments("-headless");
		}

		options.setAcceptInsecureCerts(ConfigReader.getBoolean("acceptInsecureCerts"));

		return options;
	}

	public static EdgeOptions getEdgeOptions() {

		EdgeOptions options = new EdgeOptions();

		if (ConfigReader.getBoolean("headless")) {
		    options.addArguments("-headless");
		}

		options.setAcceptInsecureCerts(ConfigReader.getBoolean("acceptInsecureCerts"));
		return options;
	}
}
