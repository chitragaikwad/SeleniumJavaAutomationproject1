package com.nocommercedemo.Pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class ShopingCartPage extends Baseclass {

	Action action = new Action();

	@FindBy(xpath = "//span[@class='cart-label']")
	WebElement shoping_cart_link;

	@FindBy(xpath = "//a[@id='open-estimate-shipping-popup']")
	WebElement shoping_cart_estimation_btn;

	@FindBy(xpath = "//input[@id='ZipPostalCode']")
	WebElement shoping_cart_zipcode;

	@FindBy(xpath = "//input[@type='radio']")
	List<WebElement> radio_button;

	@FindBy(xpath = " //button[@title='Close (Esc)']")
	WebElement shpping_Apply_btn;

	@FindBy(xpath = "  //input[@id='termsofservice']")
	WebElement termsofservice_chkbox;

	@FindBy(xpath = "  //button[@id='checkout']")
	WebElement checkout_btn;

	@FindBy(xpath = "  //button[normalize-space()='Checkout as Guest']")
	WebElement guest_btn;

	// Page factory Initialization:

	public ShopingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Actions:

	public String ValidatecartPageTitle() {// GET TITLE OF cart PAGE
		return getDriver().getTitle();
	}

	public void ADDTOCARTFUNCTION() throws InterruptedException

	{

		WebElement item_add_cart = getDriver().findElement(By.xpath("//span[@class='sku-number']"));

		if (item_add_cart.isDisplayed()) {
			System.out.println("Item 1 was added to the add to cart");

		} else {

			System.out.println("Item 1 was NOT added to the add to cart");
		}

		System.out.println("name of product:" + item_add_cart.getText()); // get name of item added to cart

		// price check:
		WebElement correctpriceDisplay = getDriver().findElement(By.xpath("//span[@class='product-unit-price']"));

		if (correctpriceDisplay.isDisplayed()) {
			System.out.println("Item 1 was added  price is correct");
		} else {
			System.out.println("Item 1 was price not correct");
		}

		System.out.println("name of product:" + correctpriceDisplay.getText()); // get price

		// Quantity check:
		WebElement correctQuntyDisplay = getDriver().findElement(By.xpath("//input[@class='qty-input']"));

		if (correctQuntyDisplay.isDisplayed()) {
			System.out.println("Item 1 was added  qunantity is correct");
		} else {
			System.out.println("Item 1  quantity not correct");
		}
		System.out.println("name of product:" + correctQuntyDisplay.getText());

		// Update the item in the cart
		WebElement updatedItem1 = getDriver().findElement(By.xpath("//span[@class='sku-number']"));

		WebElement updateButton = updatedItem1.findElement(By.xpath("//button[@id='updatecart']"));

		updateButton.click();

		// Verify the item was updated in the cart
		WebElement updatedcartItem1 = getDriver().findElement(By.xpath("//button[@id='updatecart']"));

		if (updatedcartItem1.isDisplayed()) {
			System.out.println("Item 1 was updated in the cart");
		} else {
			System.out.println("Item 1 was NOT updated in the cart");
		}
		
		
//		 WebElement remove_from_cart = getDriver().findElement(By.xpath("//button[@class='remove-btn']"));

//		 remove_from_cart.click();

//		  if(remove_from_cart.isDisplayed())
//		{
//		  System.out.println("Item 1  removed  from the cart");
//		  } 
//			else {
//		  System.out.println("Item 1 was NOT added to the cart");
//		  }

		//gift wrapping option:
		Select GiftWrapping = new Select(getDriver().findElement(By.xpath("//select[@id='checkout_attribute_1']")));

		List<WebElement> GW = GiftWrapping.getOptions();

		System.out.println("Dropdown size is:" + GW.size());

		for (int i = 0; i < GW.size(); i++) {
			System.out.println("list of all items:" + GW.get(i).getText());
		}
		GiftWrapping.selectByIndex(1);// SELECT gift wrapping option-yes

		shoping_cart_estimation_btn.click(); // click on estimation button

//select country:
		Select country_add_cart = new Select(getDriver().findElement(By.xpath("//select[@id='CountryId']")));

		List<WebElement> cd = country_add_cart.getOptions();

		System.out.println("Dropdown size is:" + cd.size());

		for (int i = 0; i < cd.size(); i++) {
			System.out.println("list of all items:" + cd.get(i).getText());
		}
		country_add_cart.selectByValue("133");// SELECT country India

		shoping_cart_zipcode.click(); // click on Zip code
		Thread.sleep(1000);

		shoping_cart_zipcode.clear();
		Thread.sleep(1000);

		shoping_cart_zipcode.sendKeys("1234"); // enter zip code

//			 for (int i = 0; i < radio_button.size(); i++) // SELECT shipping method
//		     {
//					if (radio_button.get(i).isDisplayed() && radio_button.get(i).isEnabled()) 
//		                 {

//						radio_button.get(i).click();

//						}
//		       } 

//			radio_button.get(0).click();//by ground

		shpping_Apply_btn.click(); // click on apply button
		Thread.sleep(1000);

		termsofservice_chkbox.click();// check in terms and services check box
		Thread.sleep(1000);

		checkout_btn.click();// click on check out button
		Thread.sleep(1000);

		guest_btn.click();// click on guest button
		Thread.sleep(1000);

	}

}
