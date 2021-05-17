package com.qa.smallcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.smallcase.util.ElementActions;

public class amazonShoppingCartPage {

	public WebDriver driver;
	public ElementActions elementactions;
	
	
	//Page locators - amazonShoppingCartPage
	
	By priceValue=By.cssSelector(".a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold");
	
	
	//Page constructor - amazonShoppingCartPage
	
	public amazonShoppingCartPage(WebDriver driver){
		this.driver=driver;
		elementactions = new ElementActions(driver);
	}
	
	
	//page actions - amazonShoppingCartPage
	
	/**
	 * This method will fetch the product price from amazons shopping cart
	 * @return
	 */
	public int fetchCartProdPrice(){
		elementactions.waitTillElementPresent(priceValue);
		
		String price = elementactions.performGetText(priceValue);
		//System.out.println("amazon price:"+price);
		
    int prodPrice = elementactions.convertAmazonPricetoLong(price);
	return prodPrice;
	}
}
