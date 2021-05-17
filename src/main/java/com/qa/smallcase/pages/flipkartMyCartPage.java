package com.qa.smallcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.smallcase.util.AppConstants;
import com.qa.smallcase.util.ElementActions;

public class flipkartMyCartPage {

	public WebDriver driver;
	public ElementActions elementactions;

	// Page By locator -flipkartMyCartPage

	By increaseQtyBtn = By.xpath("(//button[@class='_23FHuj'])[position()=2]");
	By priceValue = By.xpath("(//div[@class='_3fSRat']//span)[position()=1]");
	
	                           
	By quantityValue = By.xpath("//div[@class='_3dY_ZR']//input[@type='text']");

	// Page constructor - flipkartMyCartPage

	public flipkartMyCartPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(driver);

	}

	// Page Actions - flipkartMyCartPage

	/**
	 * This method will increase the product quantity on Flipkarts MyCart Page
	 */
	public void increaseProdQty() {
		String title = elementactions.waitTillTitle(AppConstants.my_cart_title);

		if (title.contains(AppConstants.my_cart_title)) {
			elementactions.waitTillElementPresent(increaseQtyBtn);
			elementactions.doClick(increaseQtyBtn);
			elementactions.waitTillAttribute(quantityValue, "value", AppConstants.prodQty);

			String qtyvalue = elementactions.getElement(quantityValue).getAttribute("value");
			// System.out.println("my cart qty value-" + qtyvalue);
		} else {
			System.out.println("Some error occurred navigating to My Cart Page");
		}
	}

	/**
	 * This method is used to fetch price value from the my cart page
	 * @return
	 */
	public long fetchPrice() {

		elementactions.waitTillElementPresent(priceValue);
		String priceText = elementactions.performGetText(priceValue);
		Long price = elementactions.convertPricetoLong(priceText);
		// System.out.println("price is-"+price);

		return price;
	}
	
	
	
}