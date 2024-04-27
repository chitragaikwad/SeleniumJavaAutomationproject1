package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.LoginPage;
import com.nocommercedemo.Pageclass.RegisterPage;
import com.nocommercedemo.utility.Log;

public class LoginPageTest extends Baseclass {
	RegisterPage registrationpage;
	LoginPage loginpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser);
		loginpage = new LoginPage();

	}

	@Test
	public void logintitlepage() {
		Log.startTestCase("logintitlepage");
		Log.info("user is going to  verify login  titlepage");
		loginpage = new LoginPage();
		String title = loginpage.ValidateloginPageTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Login");
		System.out.println("title of page:" + title);
		Log.info("login page title is verified");
		Log.endTestCase("logintitlepage");
	}

	@Test
	public void loginpage() throws Throwable {

		Log.startTestCase("loginpage");
		Log.info("user is going to login");
		loginpage.Logincredentials((prop.getProperty("username")), (prop.getProperty("password")));
		Log.info("login is sucessfull");
		Log.endTestCase("loginpage");
	}

}