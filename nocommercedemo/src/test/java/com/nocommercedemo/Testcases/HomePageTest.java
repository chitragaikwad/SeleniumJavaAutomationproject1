package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.HomePage;
import com.nocommercedemo.utility.Log;

public class HomePageTest extends Baseclass {

	HomePage homepage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser);
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void homepagepageTitle() {
		Log.startTestCase("homepagepageTitle");
		Log.info("user is going to  verify homepage  titlepage");
		String title = homepage.ValidatehomePageTitle();
		Assert.assertEquals(title, "nopCommerce demo store");
		System.out.println("title of homepage:" + title);
		Log.info("home page title is verified");
		Log.endTestCase("homepagepageTitle");
	}

	@Test(priority = 2)
	public void homepageallfunctions() throws InterruptedException {
		Log.startTestCase("homepageallfunctions");
		Log.info("user is going to verifyhomepage");
		homepage.homepageelements();
		Log.info(" homepage is verified");
		Log.endTestCase("homepageallfunctions");

	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
