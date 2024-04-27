package com.nocommercedemo.Pageclass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class HomePage extends Baseclass {

	Action action = new Action();// action class

	@FindBy(xpath = "//img[@alt='nopCommerce demo store']")
	WebElement logo_homepage;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']")
	WebElement headerlist_homepage;

	@FindBy(xpath = "//a[normalize-space()='Computers']")
	WebElement computerlink;

	@FindBy(xpath = "//ul[@class='sublist']")
	WebElement typeofcomputrs;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
	WebElement Electronicslink;

	@FindBy(xpath = "//ul[@class='sublist']")
	WebElement sublistofelectronics;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
	WebElement Apparellink;

	@FindBy(xpath = "//ul[@class='sublist']")
	WebElement Apparelsublist;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
	WebElement digitaldownloadslink;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
	WebElement bookslink;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
	WebElement jewelrylink;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
	WebElement giftcardslink;

	@FindBy(xpath = "//input[@id='small-searchterms']")
	WebElement search_text;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchbar_btn1;

	@FindBy(xpath = "//input[@id='advs']")
	WebElement advancesearch_chkbox;

	@FindBy(xpath = "//div[@class='form-fields']")
	WebElement adv_searchbar2_text;

	@FindBy(xpath = "//input[@id='isc']")
	WebElement automatic_chkbox;

	@FindBy(xpath = "//input[@id='sid']")
	WebElement discription_chkbox;

	@FindBy(xpath = "//button[@class='button-1 search-button']")
	WebElement adv_search_btn2;

	// Initialization of page factory:
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	// Actions:

	public String ValidatehomePageTitle() { // get home page title
		return getDriver().getTitle();
	}
	
	

	public void homepageelements() throws InterruptedException {
		

		action.isDisplayed(getDriver(), logo_homepage);// Lo-go Check
		

		// currency drop down:
		Select currency_dropdown = new Select(getDriver().findElement(By.xpath("//select[@id='customerCurrency']")));

		List<WebElement> crndrop = currency_dropdown.getOptions();

		System.out.println("Dropdown size is:" + crndrop.size());

		for (int i = 0; i < crndrop.size(); i++) {

			System.out.println("list of all items:" + crndrop.get(i).getText());
		}

		currency_dropdown.selectByValue("https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F");// SELECT
																										// currency

		headerlist_homepage.click(); // click on header list

		System.out.println("list of home page headers:" + headerlist_homepage.getText());// all headers on home page

		computerlink.click();// click on computer link
		System.out.println("all types of computer:" + typeofcomputrs.getText());// get list of types of computers
		Thread.sleep(2000);

		Electronicslink.click();// click on computer link
		System.out.println("all sublist of electronics:" + sublistofelectronics.getText());// get list of types of //
																							// electronics
		Thread.sleep(2000);

		Apparellink.click();
		System.out.println("allsublist of Apparel :" + Apparelsublist.getText());// get list of types of apparel
		Thread.sleep(2000);

		digitaldownloadslink.click();
		System.out.println("name of link :" + digitaldownloadslink.getText());// digital downloads
		Thread.sleep(2000);

		bookslink.click();
		System.out.println("name of link :" + bookslink.getText());// books
		Thread.sleep(2000);

		jewelrylink.click();
		System.out.println("name of link :" + jewelrylink.getText());// jewelry
		Thread.sleep(2000);

		giftcardslink.click();
		System.out.println("name of link:" + giftcardslink.getText());// gift cards
		Thread.sleep(2000);

		search_text.click(); // click on search bar

		search_text.sendKeys("shoes"); // enter value in search bar as ,shoes'
		Thread.sleep(2000);

		searchbar_btn1.click(); // click on search button
		Thread.sleep(2000);

		advancesearch_chkbox.click(); // click on advance search button

//  adv_searchbar2_text .click();

//	action.type(adv_searchbar2_text,"shoes");

		// SELECT category drop down:
		Select category = new Select(getDriver().findElement(By.xpath("//select[@id='cid']")));

		List<WebElement> c = category.getOptions();

		System.out.println("Dropdown size is:" + c.size());

		for (int i = 0; i < c.size(); i++) {

			System.out.println("list of all items:" + c.get(i).getText());
		}
		category.selectByValue("10");

//		automatic_chkbox.click();

		// SELECT manufacturer drop down:
		Select manufacturer = new Select(getDriver().findElement(By.xpath("//select[@id='mid']")));

		List<WebElement> c1 = manufacturer.getOptions();

		System.out.println("Dropdown size is:" + c1.size());

		for (int i = 0; i < c1.size(); i++) {

			System.out.println("list of all items:" + c1.get(i).getText());
		}
		manufacturer.selectByValue("3");// SELECT manufacturer HP

//		discription_chkbox.click();

		adv_search_btn2.click(); // click on advance search button

	}

}
