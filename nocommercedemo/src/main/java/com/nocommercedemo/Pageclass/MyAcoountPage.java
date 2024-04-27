package com.nocommercedemo.Pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class MyAcoountPage extends Baseclass {

	Action action = new Action();

	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement MyAccountlink;

	@FindBy(xpath = "//a[normalize-space()='Customer info']")
	WebElement Customer_info;

	@FindBy(xpath = "//button[@id='save-info-button']")
	WebElement save_btn;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[2]/a")
	WebElement address;

	@FindBy(xpath = "//button[normalize-space()='Add new']")
	WebElement addnewaddress;

	@FindBy(xpath = "//input[@id='Address_FirstName']")
	WebElement add_firstname;

	@FindBy(xpath = "//input[@id='Address_LastName']")
	WebElement add_lastname;

	@FindBy(xpath = "//input[@id='Address_Email']")
	WebElement add_email;

	@FindBy(xpath = "//input[@id='Address_Company']")
	WebElement add_company;

	@FindBy(xpath = "//input[@id='Address_City']")
	WebElement add_city;

	@FindBy(xpath = "//input[@id='Address_Address1']")
	WebElement add_aad1;

	@FindBy(xpath = "//input[@id='Address_ZipPostalCode']")
	WebElement add_postalcode;

	@FindBy(xpath = "//input[@id='Address_PhoneNumber']")
	WebElement add_phone;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement add_save_btn;
	

	// Initialization of page factory:

	public MyAcoountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	// Actions:

	public String ValidateaccountPageTitle() { // get my account title page
		MyAccountlink.click();
		return getDriver().getTitle();
	}
	

	public void customerinfo(String Firstname, String Lastname, String Email, String Company, String city, String add1,
			String postalcode, String phone) {
		
		try {

			action.click(getDriver(), MyAccountlink); // click on my account link

			Customer_info.click();// click on customer Info link

			save_btn.click(); // click on save button

			address.click(); // click on address link

			addnewaddress.click(); // click on new addresses link

			action.type(add_firstname, Firstname);// ENTER FIRSTNAME

			action.type(add_lastname, Lastname);// enter last name

			action.type(add_email, Email);// enter email

			action.type(add_company, Company);// enter company name
			

             // select country drop down:

			Select country = new Select(getDriver().findElement(By.xpath("//select[@id='Address_CountryId']")));

			List<WebElement> allitems1 = country.getOptions();

			System.out.println("Dropdown size is:" + allitems1.size());

			for (int i = 0; i < allitems1.size(); i++) {

				System.out.println("list of all items:" + allitems1.get(i).getText());

			}

			country.selectByValue("133");// India

			action.type(add_city, city);// enter city name

			action.type(add_aad1, add1);// enter address in line 1

			action.type(add_postalcode, postalcode);// enter postal code

			action.type(add_phone, phone); // enter phone number

			add_save_btn.click();// click on save button

		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
	}
}
