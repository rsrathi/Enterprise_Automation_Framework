package com.enterprise.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.enterprise.config.ConfigReader;
import com.enterprise.constants.FrameworkConstants;

public final class BrowserManager {
	private BrowserManager() {
	}

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();

		if (ConfigReader.getBoolean(FrameworkConstants.HEADLESS)) {
			options.addArguments("--headless=new");
		}
		if (ConfigReader.getBoolean(FrameworkConstants.INCOGNITO)) {
		    options.addArguments("--incognito");
		}
		if (ConfigReader.getBoolean(FrameworkConstants.DISABLE_NOTIFICATIONS)) {
		    options.addArguments("--disable-notifications");
		}

		options.setAcceptInsecureCerts(ConfigReader.getBoolean(FrameworkConstants.ACCEPT_INSECURE_CERTS));

		return options;
	}

	public static FirefoxOptions getFirefoxOptions() {

		FirefoxOptions options = new FirefoxOptions();

		if (ConfigReader.getBoolean(FrameworkConstants.HEADLESS)) {
		    options.addArguments("-headless");
		}

		options.setAcceptInsecureCerts(ConfigReader.getBoolean(FrameworkConstants.ACCEPT_INSECURE_CERTS));

		return options;
	}

	public static EdgeOptions getEdgeOptions() {

		EdgeOptions options = new EdgeOptions();

		if (ConfigReader.getBoolean(FrameworkConstants.HEADLESS)) {
		    options.addArguments("-headless");
		}

		options.setAcceptInsecureCerts(ConfigReader.getBoolean(FrameworkConstants.ACCEPT_INSECURE_CERTS));
		return options;
	}
}
