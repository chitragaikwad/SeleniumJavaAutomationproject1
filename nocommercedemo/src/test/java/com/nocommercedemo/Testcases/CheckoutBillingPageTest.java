package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.CheckoutBillingPage;
import com.nocommercedemo.Pageclass.ProductInfoPage;
import com.nocommercedemo.Pageclass.ShopingCartPage;
import com.nocommercedemo.Pageclass.WhishlistPage;
import com.nocommercedemo.dataprovider.DataProviders;
import com.nocommercedemo.utility.Log;

public class CheckoutBillingPageTest extends Baseclass {
	ProductInfoPage productinfopage;
	WhishlistPage whishlistpage;
	ShopingCartPage shopingcartpage;
	CheckoutBillingPage checkoutbillingpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) throws InterruptedException {
		launchApp(browser);

		productinfopage = new ProductInfoPage();
		whishlistpage = new WhishlistPage();
		shopingcartpage = new ShopingCartPage();
		checkoutbillingpage = new CheckoutBillingPage();

		productinfopage.product();
		whishlistpage.wishlistpagefunction();
		shopingcartpage.ADDTOCARTFUNCTION();
	}

	@Test
	public void verifytitleofbillingpage() {
		Log.startTestCase("verifytitleofbillingpage");
		Log.info("user is going to  verify  billingpage title");
		String title1 = checkoutbillingpage.titleofbillingpage();
		String expectedTitle = "nopCommerce demo store. Checkout";
		String originalTitle = getDriver().getTitle();
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
		Log.info("billingpage title is verified");
		Log.endTestCase("verifytitleofbillingpage");
	}

	@Test(dataProvider = "billingpagedetails", dataProviderClass = DataProviders.class)
	public void verifybillingpage(String Firstname, String Lastname, String Email, String Company, String city,
			String add1, String postalcode, String phone) throws InterruptedException {
		Log.startTestCase("verifybillingpage");
		Log.info("user is going to verifybillingpage");
		checkoutbillingpage.Billingpage(Firstname, Lastname, Email, Company, city, add1, postalcode, phone);
		Log.info("billingpage is verified");
		Log.endTestCase("verifybillingpage");
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
