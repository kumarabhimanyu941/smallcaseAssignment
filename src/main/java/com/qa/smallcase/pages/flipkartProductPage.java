package com.qa.smallcase.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.smallcase.util.ElementActions;

public class flipkartProductPage {

	public WebDriver driver;
	public ElementActions elementactions;

	// Page By locators-flipkart product page

	By prodName=By.xpath("//div[@class='_1AtVbE col-12-12']//span[@class='B_NuCI']");
	By priceLabel = By.xpath("//div[@class='aMaAEs']//div[@class='_30jeq3 _16Jk6d']");
	By addToCartBtn = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");

	// page constructor - flipkart product page

	public flipkartProductPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(driver);
	}

	// page actions - flipkart product page

	
	/**
	 * This method will fetch the product name,convert it to lower case and return
	 * @return String prodName
	 */
	public String fetchProductName(){
		elementactions.waitTillElementPresent(prodName);
		String prod=elementactions.performGetText(prodName);
		String prodName=prod.toLowerCase();
		return prodName;
	}
	
	
	/**
	 * This method will fetch the product price
	 * 
	 * @return
	 */
	public long fetcProductPrice() {

		String priceText = elementactions.performGetText(priceLabel);

		long price = elementactions.convertPricetoLong(priceText);
		return price;
	}

	/**
	 * this method will click on the add to cart button
	 */

	public void addToCart() {
		
		elementactions.waitTillElementPresent(addToCartBtn);
		elementactions.doClick(addToCartBtn);

	}

}
