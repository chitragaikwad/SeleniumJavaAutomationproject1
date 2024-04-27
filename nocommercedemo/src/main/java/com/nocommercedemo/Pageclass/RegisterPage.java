package com.nocommercedemo.Pageclass;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class RegisterPage extends Baseclass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement Registerlink;

	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement radio_male;
	
	@FindBy(xpath = "//input[@id='gender-female']")
	WebElement radio_female;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement Email1;
	
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement Date1;
	
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement Month1;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement Year1;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement Companyname1;

	@FindBy(xpath = "//input[@id='Newsletter']")
	WebElement Newletter;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement Confirmpassword;

	@FindBy(xpath = "//button[@id='register-button']")
	WebElement Reg_button;

	@FindBy(xpath = "//a[@class='button-1 register-continue-button']")
	WebElement cnt_button;

	
	
	// Initialization of page factory:
	public RegisterPage () {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	// Actions:
		public String ValidateregiisterPageTitle() {// GET TITLE OF register  PAGE
			Registerlink.click();
			return getDriver().getTitle();
		}
		
	
	public void createAccount(String gender,String Firstname, String Lastname, String Date,String Month,String Year,String Email ,String Companyname, String pw, String cp) throws Throwable {
		Registerlink.click(); // click on register link
		
		if(gender.equalsIgnoreCase("Male")) {  //select gender radio button
			action.click(getDriver(),radio_male );
		} else {
			action.click(getDriver(),radio_female );
		}
		
		action.type(FirstName, Firstname);
		action.type( LastName, Lastname);
	    action.selectByValue(Date1, Date );
		action.selectByValue(Month1, Month);
		action.selectByValue(Year1, Year);
		action.type(Email1, Email);
		action.type(Companyname1, Companyname);
		action.type(password, pw);
		action.type(Confirmpassword, cp);
		Reg_button.click();
		
	}
	
}
