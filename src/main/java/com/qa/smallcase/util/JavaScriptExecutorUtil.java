package com.qa.smallcase.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtil {

	public WebDriver driver;

	public JavaScriptExecutorUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * getElement method
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement getElement(WebDriver driver, By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Unable to locate element :" + locator);
		}
		return element;

	}

	/**
	 * This method will click on the WebElement using JavaScriptExecutor
	 * 
	 * @param driver
	 * @param loginBtn2
	 */
	public void performClickByJS(WebDriver driver, By locator) {
		WebElement element = getElement(driver, locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

}
