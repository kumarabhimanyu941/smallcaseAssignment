package com.qa.smallcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.smallcase.util.ElementActions;
import com.qa.smallcase.util.JavaScriptExecutorUtil;

public class amazonProductPage {

	public WebDriver driver;
	public ElementActions elementactions;
	public JavaScriptExecutorUtil jsExecutor;

	// Page By locators -amazonProductPage

	By productPrice = By.xpath("//div[@id='price']//span[@id='priceblock_dealprice']");
	By addToCartBtn=By.xpath("//input[@id='add-to-cart-button']");
	By cartBtn=By.xpath("//span[@id='attach-sidesheet-view-cart-button-announce']");
	By cartIcon= By.xpath("//div[@id='nav-cart-count-container']//span[@class='nav-cart-icon nav-sprite']");

	// Page constructor-amazonProductPage
	public amazonProductPage(WebDriver driver) {
		this.driver = driver;
		elementactions = new ElementActions(driver);
		jsExecutor = new JavaScriptExecutorUtil(driver);

	}

	// Page Actions - amazonProductPage

	/**
	 * This method will fetch the price of the product from the amazon product page
	 * @return price as long
	 */
	public int fetchProductPrice() {
		elementactions.waitTillElementPresent(productPrice);
		String price = elementactions.performGetText(productPrice);
		
		
		int prodPrice = elementactions.convertAmazonPricetoLong(price);
		return prodPrice;
	}

	/**
	 * This method will click on the add to cart button on the amazon product page
	 */
	public void addToCart(){
		elementactions.waitTillElementPresent(addToCartBtn);
		elementactions.doClick(addToCartBtn);
		elementactions.waitTillElemenntClickable(cartBtn);
		jsExecutor.performClickByJS(driver, cartBtn);
	}
	
	/**
	 * This method will navigate to the amazon Shopping cart page
	 */
	public void navigateToCart(){
		elementactions.waitTillElementPresent(cartIcon);
		jsExecutor.performClickByJS(driver, cartIcon);
	}
	
}
