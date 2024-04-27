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

public class OrderConfirmPage extends Baseclass {

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	WebElement confirm_order_btn;
	

	// Page factory Initialization:

	public OrderConfirmPage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	// Actions:

	public void orderconfirm() {

		// click on order confirm button
		
		Actions act = new Actions(getDriver());

		act.moveToElement(new WebDriverWait(getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Confirm']"))))
				.click().build().perform();
		

		if (confirm_order_btn.isDisplayed()) {

			System.out.println("Your order has been successfully processed!");

		} else {

			System.out.println("Your order has not processed!");
		}
		

		// confirm order detail link
		
		Actions a1 = new Actions(getDriver());

		act.moveToElement(new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[normalize-space()='Click here for order details.']")))).click()
				.build().perform();
		

		// get PDF of invoice
		Actions h = new Actions(getDriver());

		act.moveToElement(new WebDriverWait(getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button-2 pdf-invoice-button']"))))
				.click().build().perform();
		

		// get Print of invoice
		
		Actions h1 = new Actions(getDriver());

		act.moveToElement(new WebDriverWait(getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button-2 print-order-button']"))))
				.click().build().perform();

	}
}
