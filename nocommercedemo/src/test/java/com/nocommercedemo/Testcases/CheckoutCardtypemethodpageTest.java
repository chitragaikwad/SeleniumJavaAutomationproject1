package com.nocommercedemo.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.CheckoutBillingPage;
import com.nocommercedemo.Pageclass.CheckoutCardtypemethodpage;
import com.nocommercedemo.Pageclass.CheckoutPaymentmethodPage;
import com.nocommercedemo.Pageclass.CheckoutShippingMethodPage;
import com.nocommercedemo.Pageclass.ProductInfoPage;
import com.nocommercedemo.Pageclass.ShopingCartPage;
import com.nocommercedemo.Pageclass.WhishlistPage;
import com.nocommercedemo.utility.Log;

public class CheckoutCardtypemethodpageTest extends Baseclass {

	ProductInfoPage productinfopage;
	WhishlistPage whishlistpage;
	ShopingCartPage shopingcartpage;
	CheckoutBillingPage checkoutbillingpage;
	CheckoutShippingMethodPage checkoutshippingmethodpage;
	CheckoutPaymentmethodPage checkoutpaymentmethodpage;
	CheckoutCardtypemethodpage checkoutcardtypemethodpage;

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
		checkoutcardtypemethodpage = new CheckoutCardtypemethodpage();
		productinfopage.product();
		whishlistpage.wishlistpagefunction();
		shopingcartpage.ADDTOCARTFUNCTION();
		checkoutbillingpage.Billingpage("rohit", "sharma", "rohit@gmail.com", "abc pvt ltd", "pune", "katraj,pune",
				"234", "5678");
		checkoutshippingmethodpage.shippingmathod();
		checkoutpaymentmethodpage.paymentmethod();
	}

	@Test
	public void verifycardmethodmethodpage() throws InterruptedException {
		Log.startTestCase("verifycardmethodmethodpage");
		Log.info("user is going to verifycreditcardpaymentmethodpage");
		checkoutcardtypemethodpage.Cardpayment();
		Log.info(" creditcardpaymentmethodpage is verified");
		Log.endTestCase("verifycardmethodmethodpage");
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
