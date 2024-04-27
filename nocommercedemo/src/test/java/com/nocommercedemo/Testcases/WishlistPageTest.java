package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.ProductInfoPage;
import com.nocommercedemo.Pageclass.WhishlistPage;
import com.nocommercedemo.utility.Log;

public class WishlistPageTest extends Baseclass {

	ProductInfoPage productinfopage;
	WhishlistPage whishlistpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) throws InterruptedException {
		launchApp(browser);

		productinfopage = new ProductInfoPage();
		whishlistpage = new WhishlistPage();
		productinfopage.product();
	}

	@Test(priority = 1)
	public void wishlistpagepageTitle() {
		Log.startTestCase("wishlistpagepageTitle");
		Log.info("user is going to  verify wishlist  titlepage");
		String title = whishlistpage.ValidatewishlistPageTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Wishlist");
		System.out.println("title of homepage:" + title);
		Log.info("whishlist title is verified");
		Log.endTestCase("wishlistpagepageTitle");
	}

	@Test
	public void wishlisttable() throws InterruptedException {
		Log.startTestCase("wishlisttable");
		Log.info("user is going to  verify whishlistpage");
		whishlistpage.wishlistpagefunction();
		Log.info("whishlistpage is verified");
		Log.endTestCase("wishlisttable");

	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
