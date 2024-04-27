package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.ProductInfoPage;
import com.nocommercedemo.Pageclass.ShopingCartPage;
import com.nocommercedemo.Pageclass.WhishlistPage;
import com.nocommercedemo.utility.Log;

public class ShopingCartPageTest extends Baseclass {
	ProductInfoPage productinfopage;
	WhishlistPage whishlistpage;
	ShopingCartPage shopingcartpage;
	

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) throws InterruptedException {
		launchApp(browser);

		productinfopage = new ProductInfoPage();
		whishlistpage = new WhishlistPage();
		shopingcartpage = new ShopingCartPage();
		productinfopage.product();
		whishlistpage.wishlistpagefunction();
	}

	@Test(priority = 1)
	public void CartpageTitle() throws InterruptedException {
		Log.startTestCase("CartpageTitle");
		Log.info("user is going to  verify addtocart titlepage");
		String title = shopingcartpage.ValidatecartPageTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Shopping Cart");
		System.out.println("title of page:" + title);
		Log.info("title of addtocart is verified");
		Log.endTestCase("CartpageTitle");
	}

	@Test(priority = 2)
	public void verifyAddtocart() throws InterruptedException {
		Log.startTestCase("verifyAddtocart");
		Log.info("user is going to add item in cart");
		shopingcartpage.ADDTOCARTFUNCTION();
		Log.info("item is added to cart");
		Log.endTestCase("verifyAddtocart");
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
