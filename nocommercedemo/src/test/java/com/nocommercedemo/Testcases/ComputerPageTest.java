package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.ComputerPage;
import com.nocommercedemo.utility.Log;

public class ComputerPageTest extends Baseclass {

	ComputerPage computerpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser);
		computerpage = new ComputerPage();
	}

	@Test(priority = 1)
	public void computerpageTitle() {
		Log.startTestCase("computerpageTitle");
		Log.info("user is going to  verify computer  titlepage");
		String title = computerpage.ValidatecomputerPageTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Computers");
		System.out.println("title of page:" + title);
		Log.info("computerpage title is verified");
		Log.endTestCase("computerpageTitle");
	}

	@Test(priority = 2)
	public void computeritems() throws InterruptedException {

		Log.startTestCase("computeritems ");
		Log.info("user is going to verifycomputerpage");
		computerpage.Computerlist();
		Log.info(" computerpage is verified");
		Log.endTestCase("computeritems ");

	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
