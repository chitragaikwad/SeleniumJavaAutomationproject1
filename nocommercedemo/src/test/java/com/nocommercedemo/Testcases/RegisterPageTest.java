package com.nocommercedemo.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.Pageclass.RegisterPage;
import com.nocommercedemo.dataprovider.DataProviders;
import com.nocommercedemo.utility.Log;

public class RegisterPageTest extends Baseclass {

	RegisterPage registrationpage;

	@Parameters("browser")
	@BeforeMethod()
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser);
	}

	@Test
	public void Registertitlepage() {
		registrationpage = new RegisterPage();
		Log.startTestCase("Registertitlepage");
		Log.info("user is going to verify register titlepage");
		String title = registrationpage.ValidateregiisterPageTitle();
		Assert.assertEquals(title, "nopCommerce demo store. Register");
		System.out.println("title of page:" + title);
		Log.info("title of registerpage is verified");
		Log.endTestCase("Registertitlepage");
	}

	@Test(dataProvider = "registrationdetails", dataProviderClass = DataProviders.class)
	public void createAccountTest(String gender, String Firstname, String Lastname, String Date, String Month,
			String Year, String Email, String Companyname, String pw, String cp) throws Throwable {

		Log.startTestCase("createAccountTest");
		Log.info("user is going to register");
		registrationpage = new RegisterPage();
		registrationpage.createAccount(gender, Firstname, Lastname, Date, Month, Year, Email, Companyname, pw, cp);
		Log.info("registrationsuccesfull");
		Log.endTestCase("createAccountTest");
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

}
