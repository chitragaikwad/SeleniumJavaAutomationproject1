package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.ComputerPage;
import com.nocommercedemo.Pageclass.DeskTopPage;
import com.nocommercedemo.utility.Log;

public class DeskTopPageTest extends Baseclass {

	ComputerPage computerpage;
	DeskTopPage desktoppage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) throws InterruptedException {
		launchApp(browser);
		computerpage = new ComputerPage();
		desktoppage = new DeskTopPage();
		computerpage.Computerlist();

	}

	@Test(priority = 1)
	public void desktoppageTitle() {
		Log.startTestCase("desktoppageTitle");
		Log.info("user is going to  verify desktop  titlepage");
		String title = desktoppage.ValidatedesktopPageTitle();
		System.out.println("title of page:" + title);
		Assert.assertEquals(title, "nopCommerce demo store. Desktops");
		Log.info("dessktop page title is verified");
		Log.endTestCase("desktoppageTitle");
	}

	@Test(priority = 2)
	public void selectcputype() throws InterruptedException {
		Log.startTestCase("selectcputype ");
		Log.info("user is going to select desktop");
		desktoppage.cputype();
		Log.info(" cpu desktop is selected");
		Log.endTestCase("selectcputype");

	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
