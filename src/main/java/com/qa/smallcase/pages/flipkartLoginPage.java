package com.qa.smallcase.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.smallcase.util.AppConstants;
import com.qa.smallcase.util.ElementActions;

public class flipkartLoginPage {

	public WebDriver driver;
	public ElementActions elementactions;

	// Page By locators - flipkartloginPage

	By searchBox = By.xpath("//input[@class='_3704LK' and @type='text']");
	By searchList = By.xpath("//div[@class='_3pLy-c row']//div[@class='_4rR01T']");
	By LoginPopUp_cancel = By.xpath("//button[@class='_2KpZ6l _2doB4z']");

	// loginPage Constructor

	public flipkartLoginPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(driver);
	}

	// Page Actions -loginPage

	public void enterSearchValue(String value) {
		elementactions.waitTillElementPresent(LoginPopUp_cancel);
		elementactions.doClick(LoginPopUp_cancel);
		elementactions.waitTillElementPresent(searchBox);
		elementactions.getElement(searchBox);
		elementactions.doSendKeys(searchBox, value);
		elementactions.doEnter(searchBox);

	}

	/**
	 * This method will get the text of the mentioned product name
	 * 
	 * @return product name in lower case
	 */
	public void clickOnSearchResult() {

		elementactions.waitTillElementPresent(searchList);
		List<WebElement> searchresult = elementactions.getElements(searchList);

		searchresult.get(AppConstants.productNumber).click();

	}

	/**
	 * This method will switch the driver control to the new window
	 */
	public void switchToNewWindow() {
		String parentWindow = elementactions.fetchWindowHandle();
		Set<String> windowHandles = elementactions.fetchWindowHandles();

		for (String handle : windowHandles)
			if (!windowHandles.equals(parentWindow)) {
				elementactions.switchWindow(handle);
			}
	}

}
