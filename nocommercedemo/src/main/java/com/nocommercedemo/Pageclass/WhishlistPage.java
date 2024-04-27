package com.nocommercedemo.Pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class WhishlistPage extends Baseclass {
	
	Action action = new Action();

	@FindBy(xpath = "//input[@name='addtocart']")
	WebElement add_to_cart_chkbox1;
	
    @FindBy(xpath = "//input[@class='qty-input']")
	WebElement add_to_cart_qty;

	@FindBy(xpath = "//button[@name='addtocartbutton']")
	WebElement add_to_cart_btn;
	

	// Initialization of page factory:

	public WhishlistPage() {  
		PageFactory.initElements(getDriver(), this);
	}
	

	// Actions:

	public String ValidatewishlistPageTitle() { // get title of wish list page

		return getDriver().getTitle();
	}
	

	public void wishlistpagefunction() throws InterruptedException{
	
	    // Verify the item was added to the wish list
		WebElement wishlistItem1 = getDriver().findElement(By.xpath("//span[@class='sku-number']"));

		if (wishlistItem1.isDisplayed()) {
			System.out.println("Item 1 was added to the wishlist");
		} else {
			System.out.println("Item 1 was NOT added to the wishlist");
		}
		
		
		// Update the item in the wish list
		WebElement updatedItem1 = getDriver().findElement(By.xpath("//span[@class='sku-number']"));

		WebElement updateButton = updatedItem1.findElement(By.xpath("//button[@id='updatecart']"));

		updateButton.click();
		
		
		// Verify the item was updated in the wish list
		WebElement updatedWishlistItem1 = getDriver().findElement(By.xpath("//button[@id='updatecart']"));

		if (updatedWishlistItem1.isDisplayed()) {
			System.out.println("Item 1 was updated in the wishlist");
		} else {
			System.out.println("Item 1 was NOT updated in the wishlist");
		}
		
		Thread.sleep(2000);
		
		
		  //Remove the item2 from the wish list:
		
           WebElement wishlistItem2 = getDriver().findElement(By.xpath("//span[@class='sku-number']"));
           
			// Verify the item was removed from the wish list

			if (wishlistItem2.isDisplayed()) {
				System.out.println("Item 2 was removed from the wishlist");
			} else {
				System.out.println("Item 2 was NOT removed from the wishlist");
			}

            //Remove the item2 from the wish list

			WebElement removeButton = wishlistItem2.findElement(By.xpath("//tbody/tr[1]/td[8]/button[1]"));
            removeButton.click();
			Thread.sleep(2000);
		
		
		add_to_cart_qty.clear(); // Clear the quantity field first before entering any value

		action.type(add_to_cart_qty,"1");// enter quantity

		add_to_cart_chkbox1.click();// click add to  cart check box
		
		add_to_cart_btn.click(); //click on add to cart button

	}

}
