package com.nocommercedemo.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.CheckoutBillingPage;
import com.nocommercedemo.Pageclass.CheckoutPaymentmethodPage;
import com.nocommercedemo.Pageclass.CheckoutShippingMethodPage;
import com.nocommercedemo.Pageclass.ProductInfoPage;
import com.nocommercedemo.Pageclass.ShopingCartPage;
import com.nocommercedemo.Pageclass.WhishlistPage;
import com.nocommercedemo.utility.Log;

public class CheckoutPaymentmethodPageTest extends Baseclass {
	ProductInfoPage productinfopage;
	WhishlistPage whishlistpage;
	ShopingCartPage shopingcartpage;
	CheckoutBillingPage checkoutbillingpage;
	CheckoutShippingMethodPage checkoutshippingmethodpage;
	CheckoutPaymentmethodPage checkoutpaymentmethodpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) throws InterruptedException {
		launchApp(browser);

		productinfopage = new ProductInfoPage();
		whishlistpage = new WhishlistPage();
		shopingcartpage = new ShopingCartPage();
		checkoutbillingpage = new CheckoutBillingPage();
		checkoutshippingmethodpage = new CheckoutShippingMethodPage();
		checkoutpaymentmethodpage = new CheckoutPaymentmethodPage();
		productinfopage.product();
		whishlistpage.wishlistpagefunction();
		shopingcartpage.ADDTOCARTFUNCTION();
		checkoutbillingpage.Billingpage("rohit", "sharma", "rohit@gmail.com", "abc pvt ltd", "pune", "katraj,pune",
				"234", "5678");
		checkoutshippingmethodpage.shippingmathod();
	}

	@Test
	public void verifypaymentmethodpage() throws InterruptedException {
		Log.startTestCase(" verifypaymentmethodpage");
		Log.info("user is going to verifypaymentmethodpage");
		checkoutpaymentmethodpage.paymentmethod();
		Log.info(" paymentmethodpage is verified");
		Log.endTestCase(" verifypaymentmethodpage");
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
