package com.nocommercedemo.Pageclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class CheckoutCardtypemethodpage extends Baseclass {

	Action action = new Action();

	@FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
	WebElement payment_info_cnt_btn;

	@FindBy(xpath = "//input[@id='CardholderName']")
	WebElement card_holder_name;

	@FindBy(xpath = "//input[@id='CardNumber']")
	WebElement card_number;

	@FindBy(xpath = "//input[@id='CardCode']")
	WebElement card_code;
	
	
	

	// Page factory Initialization:

	public CheckoutCardtypemethodpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	

//	Action:

	public void Cardpayment() {

		Actions act = new Actions(getDriver());
		act.moveToElement(new WebDriverWait(getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='CreditCardType']")))).click()
				.build().perform();

		Select creditcard_type = new Select(getDriver().findElement(By.xpath("//select[@id='CreditCardType']")));

		List<WebElement> all = creditcard_type.getOptions();

		System.out.println("Dropdown size is:" + all.size());

		for (int i = 0; i < all.size(); i++) {

			System.out.println("list of all items:" + all.get(i).getText());

		}

		creditcard_type.selectByValue("MasterCard");// select master card credit card type

		action.type(card_holder_name, "Rohit");// name of card holder

		action.type(card_number, "234567");// master card number starts with 2 or 5

		Select creditcard_expiryDate = new Select(getDriver().findElement(By.xpath("//select[@id='ExpireMonth']")));

		List<WebElement> all1 = creditcard_expiryDate.getOptions();
		System.out.println("Dropdown size is:" + all1.size());

		for (int i = 0; i < all1.size(); i++) {

			System.out.println("list of all items:" + all1.get(i).getText());

		}

		creditcard_expiryDate.selectByValue("11");// CREDIT CARD EXPIRY MONTH

		Select creditcard_expiryear = new Select(getDriver().findElement(By.xpath("//select[@id='ExpireYear']")));

		List<WebElement> all2 = creditcard_expiryear.getOptions();

		System.out.println("Dropdown size is:" + all2.size());

		for (int i = 0; i < all2.size(); i++) {

			System.out.println("list of all items:" + all2.get(i).getText());

		}

		creditcard_expiryear.selectByValue("2028");// CREDIT CARD EXPIRY YEAR

		action.type(card_code, "7676");// credit card code

		payment_info_cnt_btn.click();// Payment method card continue button

	}
}
