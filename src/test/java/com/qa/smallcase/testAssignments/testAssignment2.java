package com.qa.smallcase.testAssignments;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.smallcase.base.BasePage;
import com.qa.smallcase.pages.amazonLoginPage;
import com.qa.smallcase.pages.amazonProductPage;
import com.qa.smallcase.pages.amazonShoppingCartPage;
import com.qa.smallcase.pages.flipkartLoginPage;
import com.qa.smallcase.pages.flipkartMyCartPage;
import com.qa.smallcase.pages.flipkartProductPage;
import com.qa.smallcase.util.AppConstants;

public class testAssignment2 {

	public WebDriver driver;
	public Properties prop;
	public BasePage basepage;
	public flipkartLoginPage flipkartlp;
	public flipkartProductPage flipkartpp;
	public flipkartMyCartPage flipkartmycart;
	public amazonLoginPage amazonlp;
	public amazonProductPage amazonpp;
	public amazonShoppingCartPage amazoncart;

	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_Prop();
		driver = basepage.init_driver(prop);
		flipkartlp = new flipkartLoginPage(driver);
		flipkartpp = new flipkartProductPage(driver);
		flipkartmycart = new flipkartMyCartPage(driver);
		amazonlp = new amazonLoginPage(driver);
		amazonpp = new amazonProductPage(driver);
		amazoncart = new amazonShoppingCartPage(driver);

		driver.get(prop.getProperty("flipkartUrl"));

	}

	@Test
	public void checkProductPrice() {

		// Entering the search value in the search box on the login page
		flipkartlp.enterSearchValue(AppConstants.search_Value);

		// clicking on the first item in the search result
		flipkartlp.clickOnSearchResult();

		// switching to the new window
		flipkartlp.switchToNewWindow();

		//fetching the product name and storing
		String ProdName = flipkartpp.fetchProductName();
		System.out.println("Product name is:" + ProdName);
		
		// fetching and printing the price of the product
		long flipkartProdPrice = flipkartpp.fetcProductPrice();
		System.out.println("The price of the product " + ProdName + " on flipkart is INR " + flipkartProdPrice);

		// adding the product to cart
		flipkartpp.addToCart();

		// fetching the price from the cart and printing the price
		Long flipkartPrice = flipkartmycart.fetchPrice();
		System.out.println("The price of " + AppConstants.originalprodQty + " unit/units of " + ProdName
				+ "on flipkart is INR " + flipkartPrice);

		// launching amazon.in
		amazonlp.launchAmazon(prop.getProperty("amazonUrl"));

		// entering the search value in the search box on amazon login page
		amazonlp.enterSearchValue(AppConstants.search_Value);

		// fetching the same product as flipkart
		amazonlp.fetchSameProdAsFlipkart(ProdName);

		// switching control to new window
		flipkartlp.switchToNewWindow();

		// fetching the product price on amazon and printing
		int amazonProdPrice = amazonpp.fetchProductPrice();
		System.out.println("The price of " + AppConstants.originalprodQty + " unit/units of " + ProdName
				+ " on amazon is INR: " + amazonProdPrice);

		// adding the product to the cart
		amazonpp.addToCart();

		// navigating to the cart
		amazonpp.navigateToCart();

		// fetching product price from amazon cart and printing the price
		int amazonPrice = amazoncart.fetchCartProdPrice();
		System.out.println("The price of " + ProdName + " on amazon is INR " + amazonPrice);

		// performing amazon and flipkart price comparison

		if (flipkartPrice > amazonPrice) {
			System.out.println(
					"flipkart is selling " + ProdName + " at INR " + (flipkartPrice - amazonPrice) + " higher than amazon");
		} else if (amazonPrice > flipkartPrice) {
			System.out.println(
					"amazon is selling " + ProdName + " at INR " + (amazonPrice - flipkartPrice) + " higher than flipkart");
		} else {
			System.out.println("Both flipkart and amazon are sellin " + ProdName + " at same price");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}