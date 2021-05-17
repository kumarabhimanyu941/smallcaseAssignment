package com.qa.smallcase.util;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

	public WebDriver driver;
	WebDriverWait wait;
	Actions action;
	Select select;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.WebDriver_Wait_TimeOut);
		action = new Actions(driver);

	}

	// Generic functions

	/**
	 * This method will fetch an element located by the given locator
	 * 
	 * @param locator
	 * @param value
	 */

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Error occurred while creating the element : " + locator);
		}
		return element;
	}

	/**
	 * This method will return a list of WebElements based on the given locator
	 * 
	 * @param locator
	 * @return
	 */
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	/**
	 * This method will perform click on the element located by the locator
	 * 
	 * @param locator
	 * @param value
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}

	/**
	 * This method will perform sendkeys on the element located by the locator
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/**
	 * This method will perform keyboard action ENTER
	 * 
	 * @param locator
	 */
	public void doEnter(By locator) {
		getElement(locator).sendKeys(Keys.ENTER);

	}

	/**
	 * This method will wait till the element is present on the page
	 * 
	 * @param locator
	 */
	public void waitTillElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This method will wait till the element is visible on the page
	 * 
	 * @param locator
	 */
	public void waitTillElementVisible(By locator) {
		WebElement ele = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * This method will wait for the webelement until it is clickable
	 * 
	 * @param locator
	 */
	public void waitTillElemenntClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * This method will fetch the title of the page
	 * 
	 * @return title
	 * 
	 */
	public String waitTillTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	/**
	 * This method will fetch the text of the element found using the locator
	 * 
	 * @param locator
	 * @return String
	 */
	public String performGetText(By locator) {
		return getElement(locator).getText();
	}

	/**
	 * 
	 * This method will fetch the window Handle of the parent window
	 * 
	 * @return String - parent window handle
	 */
	public String fetchWindowHandle() {

		return driver.getWindowHandle();

	}

	/**
	 * This method will fetch the window Handles of all the open windows
	 * 
	 * @return Set of fetched window handles
	 */
	public Set<String> fetchWindowHandles() {
		return driver.getWindowHandles();
	}

	/**
	 * This method is used to switch to a new window based on the handle given a
	 * parameter.
	 * 
	 * @param handle
	 */
	public void switchWindow(String handle) {
		driver.switchTo().window(handle);
	}

	/**
	 * This method will remove special character from a string and convert the
	 * string into Long
	 * 
	 * @param Long
	 */
	public long convertPricetoLong(String string) {

		try {
			String str = string.replaceAll("[^a-zA-Z0-9.]", "");
			double value = Double.parseDouble(str);
			int price = (int) value;
			return price;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred during conversion of String to Long");
		}
		return -1;

	}

	/**
	 * This method will convert the price fetched from amazon to long
	 * 
	 * @param str
	 * @return
	 */
	public int convertAmazonPricetoLong(String string) {
		try {
			String str = string.replaceAll("[^a-zA-Z0-9.]", "");
			double value = Double.parseDouble(str);
			int price = (int) value;
			return price;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred during conversion of String to Long");
		}
		return -1;

	}

	/**
	 * This method will wait till the Attribute contains the mentioned value
	 * 
	 * @param locator
	 * @param attribute
	 * @param value
	 */
	public void waitTillAttribute(By locator, String attribute, String value) {
		wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
	}

	/**
	 * This method is used to launch a url
	 * 
	 * @param str
	 */
	public void launchUrl(String str) {
		driver.get(str);
	}

	/**
	 * This method will click on an element from the list if its text matches
	 * the specified value
	 * 
	 * @param list
	 * @param str
	 */
	public void clickOnListElement(List<WebElement> list, String str) {

		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();

			if (text.contains(str)) {
				list.get(i).click();
			}
		}

	}

}
