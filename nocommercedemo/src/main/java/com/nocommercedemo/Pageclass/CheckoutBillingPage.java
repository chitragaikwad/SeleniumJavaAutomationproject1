package com.nocommercedemo.Pageclass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class CheckoutBillingPage extends Baseclass {
	Action action = new Action();

	@FindBy(xpath = " //input[@id='BillingNewAddress_FirstName']")
	WebElement Billing_add_firstname;

	@FindBy(xpath = " //input[@id='BillingNewAddress_LastName']")
	WebElement Billingadd_lastname;

	@FindBy(xpath = " //input[@id='BillingNewAddress_Email']")
	WebElement Billingadd_email;

	@FindBy(xpath = " //input[@id='BillingNewAddress_Company']")
	WebElement Billingadd_company;

	@FindBy(xpath = "//input[@id='BillingNewAddress_City'] ")
	WebElement Billingadd_city;

	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	WebElement Billingadd_aad1;

	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement Billingadd_postalcode;

	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement Billingadd_phone;

	@FindBy(xpath = "//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']")
	WebElement billingcont_btn;

	@FindBy(xpath = "//button[contains(@class,'button-1 new-address-next-step-button')][1]")
	WebElement Billingcnt_button2;
	

	// Page factory Initialization:

	public CheckoutBillingPage() {

		PageFactory.initElements(getDriver(), this);
	}
	

	// Actions:

	public String titleofbillingpage() {
		return getDriver().getTitle();
	}

	public void Billingpage(String Firstname, String Lastname, String Email, String Company, String city, String add1,
			String postalcode, String phone) {

		action.type(Billing_add_firstname, Firstname);// ENTER FIRSTNAME

		action.type(Billingadd_lastname, Lastname);// ENTER LASTNAME

		action.type(Billingadd_email, Email);// ENTER EMAIL

		action.type(Billingadd_company, Company);// ENTER COMPANY NAME

		Select Billingadd_country = new Select(
				getDriver().findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));

		List<WebElement> allitems1 = Billingadd_country.getOptions();

		System.out.println("Dropdown size is:" + allitems1.size());// know the size of drop down

		for (int i = 0; i < allitems1.size(); i++) {

			System.out.println("list of all itemss:" + allitems1.get(i).getText());//get all elements of list

		}

		Billingadd_country.selectByValue("133");// select country

		action.type(Billingadd_city, city); // ENTER CITY
		
		action.type(Billingadd_aad1, add1);// ENTER ADDRESS IN LINE 1
		
		action.type(Billingadd_postalcode, postalcode);// ENTER POSTAL CODE
		
		action.type(Billingadd_phone, phone);// ENTER PHONE NUMBER
		
		billingcont_btn.click();
		
		Billingcnt_button2.click();//billing continue button

	}
}
