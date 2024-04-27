package com.nocommercedemo.Pageclass;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class ProductInfoPage extends Baseclass {

	Action action = new Action();

	@FindBy(xpath = "//div[@class='compare-products']//button[@type='button'][normalize-space()='Add to compare list']")
	WebElement add_to_compareproduct;

	@FindBy(xpath = "//button[@id='add-to-wishlist-button-8']")
	WebElement add_to_wishlist1;

	@FindBy(xpath = "//button[@id='add-to-wishlist-button-7']")
	WebElement add_to_wishlist2;

	@FindBy(xpath = "//button[@id='add-to-wishlist-button-18']")
	WebElement add_to_wishlist3;

	@FindBy(xpath = "//button[@id='add-to-cart-button-8']")
	WebElement add_to_cart;

	@FindBy(xpath = "//input[@id='product_enteredQuantity_8']")
	WebElement add_to_cart_qty;

	@FindBy(xpath = "//a[normalize-space()='Be the first to review this product']")
	WebElement revew_link;

	@FindBy(xpath = "//div[@class='rating-wrapper']")
	List<WebElement> revew_ratings_radio;

	@FindBy(xpath = "//button[@name='add-review']")
	WebElement revew_submit_btn;

	@FindBy(xpath = "//span[@id='price-value-8']")
	WebElement add_to_cart_price1;

	@FindBy(xpath = "//span[@id='price-value-18']")
	WebElement add_to_cart_price2;

	@FindBy(xpath = "//span[contains(@class,'wishlist-label')]")
	WebElement wishlistlink;

	// Initialization of page factory:

	public ProductInfoPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Actions:

	public void product() throws InterruptedException {

		getDriver().get("https://demo.nopcommerce.com/hp-spectre-xt-pro-ultrabook"); // click on product 2 link

		add_to_wishlist2.click(); // add product2 wish list button

		getDriver().get("https://demo.nopcommerce.com/hp-envy-6-1180ca-156-inch-sleekbook");// click on product1 link

//		 add_to_compareproduct.click(); //  add to compare product

		add_to_wishlist1.click();// add product 1 wish list button

		System.out.println("price of desktop sleekbook:" + add_to_cart_price1.getText());// get product 1 price text

		wishlistlink.click(); // click on wish list link

//			 add_to_cart.click();
//			 add_to_cart_qty.clear();
//			 add_to_cart_qty.sendKeys( "2");

//		revew_link.click();

//		for (int i = 0; i < revew_ratings_radio.size(); i++) 
//		{
//			if (revew_ratings_radio.get(i).isDisplayed() && revew_ratings_radio.get(i).isEnabled())
//			{
//				revew_ratings_radio.get(i).click();
//			}
//		}
//
//	
//		revew_ratings_radio.get(0).click();//reviews good
//
//				revew_ratings.get(1).click();
//
//		revew_submit_btn.click();//submit review

	}

}
