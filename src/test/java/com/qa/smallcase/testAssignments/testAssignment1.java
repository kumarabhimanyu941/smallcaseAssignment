package com.qa.smallcase.testAssignments;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.smallcase.base.BasePage;
import com.qa.smallcase.pages.flipkartLoginPage;
import com.qa.smallcase.pages.flipkartMyCartPage;
import com.qa.smallcase.pages.flipkartProductPage;
import com.qa.smallcase.util.AppConstants;
import com.qa.smallcase.config.*;

public class testAssignment1 {

	public WebDriver driver;
	public Properties prop;
	public BasePage basepage;
	public flipkartLoginPage flipkartlp;
	public flipkartProductPage flipkartpp;
	public flipkartMyCartPage flipkartmycart;

	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_Prop();
		driver = basepage.init_driver(prop);
		flipkartlp = new flipkartLoginPage(driver);
		flipkartpp = new flipkartProductPage(driver);
		flipkartmycart = new flipkartMyCartPage(driver);
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

		// Navigating to cart and increasing the product quantity
		flipkartmycart.increaseProdQty();

		// fetching the price of the increased quantity and printing the price
		Long newQtyPrice = flipkartmycart.fetchPrice();
		System.out.println("The price of " + AppConstants.prodQty + " units of " + ProdName + "on flipkart is INR " + newQtyPrice);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
