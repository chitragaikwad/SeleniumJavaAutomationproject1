package com.nocommercedemo.Pageclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nocommercedemo.Base.Baseclass;

public class CheckoutPaymentmethodPage extends Baseclass {

	@FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
	WebElement pay_mthod_cont_btn;
	
	

	// Page factory Initialization:

	public CheckoutPaymentmethodPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	

    //	Action:

	public void paymentmethod() {

		Actions act = new Actions(getDriver());
		
//payment by credit card selection
		
		act.moveToElement(new WebDriverWait(getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='paymentmethod_1']")))).click()
				.build().perform();

		WebElement payment_crd = getDriver().findElement(By.xpath("//input[@id='paymentmethod_1']"));//Credit card method
		
		

		if (payment_crd.isDisplayed()) {
			System.out.println("payment method through creditcard is selected");

		} else {
			System.out.println("payment method through creditcard is not selected");
		}
		
		

		pay_mthod_cont_btn.click();// payment method continue button

	}

}
