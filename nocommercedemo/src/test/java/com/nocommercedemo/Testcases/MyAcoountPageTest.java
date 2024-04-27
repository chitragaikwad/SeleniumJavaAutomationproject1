package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.LoginPage;
import com.nocommercedemo.Pageclass.MyAcoountPage;

import com.nocommercedemo.dataprovider.DataProviders;
import com.nocommercedemo.utility.Log;

public class MyAcoountPageTest extends Baseclass {

	LoginPage loginpage;
	MyAcoountPage myaccuntpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser);

		loginpage = new LoginPage();
		myaccuntpage = new MyAcoountPage();
		loginpage.Logincredentials((prop.getProperty("username")), (prop.getProperty("password")));

	}

	@Test(priority = 1)
	public void myaccountpageTitle() {
		Log.startTestCase("myaccountpageTitle");
		Log.info("user is going to  verify myaccount  titlepage");
		String title = myaccuntpage.ValidateaccountPageTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Account");
		System.out.println("title of page:" + title);
		Log.info("myaccount page title is verified");
		Log.endTestCase("myaccountpageTitle");
	}

	@Test(priority = 2, dataProvider = "newmyaccountdetails", dataProviderClass = DataProviders.class)
	public void myaccount(String Firstname, String Lastname, String Email, String Company, String city, String add1,
			String postalcode, String phone) {

		Log.startTestCase("myaccount");
		Log.info("user is going to verfi myaccountpage");
		myaccuntpage.customerinfo(Firstname, Lastname, Email, Company, city, add1, postalcode, phone);
		Log.info("myaccountpage is verified");
		Log.endTestCase("myaccount");
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
