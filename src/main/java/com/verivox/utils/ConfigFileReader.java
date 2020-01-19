package com.verivox.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ahsan Configuring File Reader Manager as singleton class, which will
 *         read from property file. URL, browser type etc will be configured
 *         based on property file
 */
public class ConfigFileReader {
	private Properties properties;
	InputStream inputStream;
	private static ConfigFileReader fileReaderManager;

	private ConfigFileReader() {
		try {
			inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
			properties = new Properties();
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found");
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:driverPath");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public static ConfigFileReader getInstance() {
		if (fileReaderManager == null) {
			fileReaderManager = new ConfigFileReader();
			return fileReaderManager;
		} else {
			return fileReaderManager;
		}
	}
}
