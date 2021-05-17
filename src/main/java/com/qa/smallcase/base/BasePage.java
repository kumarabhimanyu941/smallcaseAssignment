package com.qa.smallcase.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public Properties prop;
	public WebDriver driver;
	public String browser;

	/**
	 * This method will initialize and load the properties from the
	 * config.properties file
	 * 
	 * @return
	 */
	public Properties init_Prop() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/smallcase/config/config.properties");
			prop.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Config file not found");
		}

		return prop;

	}

	/**
	 * This method will instantiate the web browser based on the value fetched from the config file
	 * @param prop
	 * @return
	 */
	public WebDriver init_driver(Properties prop) {

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;

	}

}
