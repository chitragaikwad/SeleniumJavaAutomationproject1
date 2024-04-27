package com.nocommercedemo.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;

import com.nocommercedemo.Pageclass.ProductInfoPage;
import com.nocommercedemo.utility.Log;

public class ProductInfoPageTest extends Baseclass {

	ProductInfoPage productinfopage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) throws InterruptedException {
		launchApp(browser);

		productinfopage = new ProductInfoPage();

	}

	@Test
	public void addwishandcomparelist() throws InterruptedException {
		Log.startTestCase("addwishandcomparelist");
		Log.info("user is going to add product to wishlist and verify productpage page ");
		productinfopage.product();
		Log.info("product is added to whishlist and product page is verified");
		Log.endTestCase("addwishandcomparelist");

	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
