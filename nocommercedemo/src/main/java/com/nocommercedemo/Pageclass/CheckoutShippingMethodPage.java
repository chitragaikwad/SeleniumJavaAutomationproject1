package com.nocommercedemo.Pageclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class CheckoutShippingMethodPage extends Baseclass  {
	
	
	Action action= new Action();
	
	
	
	@FindBy(xpath = "//*[@id=\"shippingoption_0\"]")
	WebElement Billingradio_button;

	

	
	
	    // Page factory Initialization:
	
		public CheckoutShippingMethodPage() {
			
			
			PageFactory.initElements(getDriver(), this);
		}
	
	
	//Action:
		
	public void shippingmathod() {
		
		
     try {
			
			
//		Billingradio_button.click();// by land
		
	    Actions act	=new Actions(getDriver());
	
	//shipping by land radio button
	    act.moveToElement(new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")))).click().build().perform();

		
	
	
	}catch(ElementNotInteractableException e) {
		e.printStackTrace();
	}catch(NoSuchElementException e) {
		e.printStackTrace();
	}
	
	
	
	
}
	}
