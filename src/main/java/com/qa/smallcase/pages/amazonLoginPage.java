package com.qa.smallcase.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.smallcase.util.ElementActions;

public class amazonLoginPage {

	public WebDriver driver;
	public ElementActions elementactions;

	// Page By locators - amazonLoginPage

	By searchBox = By.xpath("//input[@type='text' and @id='twotabsearchtextbox']");
	By prodList = By.xpath("//a[@class='a-link-normal a-text-normal']");

	// Page constructor - amazonLogin page
	public amazonLoginPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(driver);
	}

	// Page actions-amazonLoginPage

	/**
	 * This method will launch the url
	 * 
	 * @param str
	 */
	public void launchAmazon(String str) {
		elementactions.launchUrl(str);
	}

	/**
	 * This method will enter search value in the amazon search box on the
	 * Welcome page
	 * 
	 * @param value
	 */
	public void enterSearchValue(String value) {
		elementactions.waitTillElementPresent(searchBox);
		elementactions.doSendKeys(searchBox, value);
		elementactions.doEnter(searchBox);
	}

	/**
	 * This method will click on the element from the list if the text of the
	 * element matches the specified value
	 * 
	 * @param value
	 */
	public void fetchSameProdAsFlipkart(String value) {
		List<Integer> list = new ArrayList<Integer>();
		String newValue = value.toLowerCase();
		String newValue1 = newValue.replaceAll("[^a-zA-Z0-9 ]", "");

		String[] array = newValue1.split(" ");
		for (int i = 0; i < array.length; i++) {
		

		}
		List<WebElement> searchList = elementactions.getElements(prodList);

		for (int i = 0; i < searchList.size(); i++) {
			String text = searchList.get(i).getText();
			String textValue = text.toLowerCase();

			

			for (int j = 0; j < array.length; j++) {
				int index = textValue.indexOf(array[j]);
				list.add(index);
			}
                                

			if (!list.contains(-1)){
				
				searchList.get(i).click();
			}
			
			
		}
		
	}
}
