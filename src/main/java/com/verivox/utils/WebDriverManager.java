package com.verivox.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author ahsan WebDriverManager is defined as singleton class and same
 *         webdriver object will be used in different scenarios
 */
public class WebDriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static WebDriverManager webDriverManager;

	private WebDriverManager() {

		driverType = ConfigFileReader.getInstance().getBrowser();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createLocalDriver();
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX: {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
			break;
		}

		case CHROME: {
			System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getDriverPath());
			driver = new ChromeDriver();
			break;
		}
		case INTERNETEXPLORER:
			System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getDriverPath());
			driver = new InternetExplorerDriver();
			break;
		}

		return driver;
	}

	public void closeDriver() {
		driver.close();
	}

	public static WebDriverManager getInstance() {
		if (webDriverManager == null) {
			webDriverManager = new WebDriverManager();
		}
		return webDriverManager;
	}
}
