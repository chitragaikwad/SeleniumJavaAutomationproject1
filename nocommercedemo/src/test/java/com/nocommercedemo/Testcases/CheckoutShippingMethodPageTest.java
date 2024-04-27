package com.nocommercedemo.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.CheckoutBillingPage;
import com.nocommercedemo.Pageclass.CheckoutShippingMethodPage;
import com.nocommercedemo.Pageclass.ProductInfoPage;
import com.nocommercedemo.Pageclass.ShopingCartPage;
import com.nocommercedemo.Pageclass.WhishlistPage;
import com.nocommercedemo.dataprovider.DataProviders;
import com.nocommercedemo.utility.Log;

public class CheckoutShippingMethodPageTest extends Baseclass {
	ProductInfoPage productinfopage;
	WhishlistPage whishlistpage;
	ShopingCartPage shopingcartpage;
	CheckoutBillingPage checkoutbillingpage;
	CheckoutShippingMethodPage checkoutshippingmethodpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) throws InterruptedException {
		launchApp(browser);

		productinfopage = new ProductInfoPage();
		whishlistpage = new WhishlistPage();
		shopingcartpage = new ShopingCartPage();
		checkoutbillingpage = new CheckoutBillingPage();
		checkoutshippingmethodpage = new CheckoutShippingMethodPage();
		productinfopage.product();
		whishlistpage.wishlistpagefunction();
		shopingcartpage.ADDTOCARTFUNCTION();

	}

	@Test(dataProvider = "billingpagedetails", dataProviderClass = DataProviders.class)
	public void verifyshippingmethodpage(String Firstname, String Lastname, String Email, String Company, String city,
			String add1, String postalcode, String phone) throws InterruptedException {
		Log.startTestCase(" verifyshippingmethodpage");
		Log.info("user is going to verifyshippingmethodpage");
		checkoutbillingpage.Billingpage(Firstname, Lastname, Email, Company, city, add1, postalcode, phone);
		checkoutshippingmethodpage.shippingmathod();
		Log.info(" shippingerthodpage is verified");
		Log.endTestCase(" verifyshippingmethodpage");
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
