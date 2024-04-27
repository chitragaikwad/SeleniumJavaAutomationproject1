package com.nocommercedemo.Pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class ComputerPage extends Baseclass {
	

	Action action = new Action();
	

	@FindBy(xpath = "//a[normalize-space()='Computers']")
	WebElement computerlink;

	@FindBy(xpath = "//li[@class='active last']//a[normalize-space()='Desktops']")
	WebElement Desktoplink;

	@FindBy(xpath = "//ul[@class='sublist']")
	WebElement typeofcomputrs;

	@FindBy(xpath = "//a[@href='/manufacturer/all']")
	WebElement all_manufact;

	@FindBy(xpath = "//ul[@class='product-tags-list']")
	WebElement all_tagslist;

	@FindBy(xpath = "//a[@href='/producttag/all']")
	WebElement all_tags;
	
	

	// Initialization of page factory:

	public ComputerPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	

	// Actions:

	public String ValidatecomputerPageTitle() {// GET TITLE OF COMPUTER PAGE
		computerlink.click();
		return getDriver().getTitle();
	}
	
	

	public void Computerlist() throws InterruptedException {

		computerlink.click();// click on computer link

		System.out.println("all types of computer:" + typeofcomputrs.getText());// get list of types of computers
		
		Thread.sleep(2000);

		all_manufact.click();// click on manufacture view all link
		
		Thread.sleep(2000);

		all_tags.click();// CLICK ON VIEW ALL TAGS

		String ltag = all_tagslist.getText();

		System.out.println("all tags list:" + ltag);// get list of tags

		computerlink.click();// computer page link

		Desktoplink.click();// desktop page link
	}
}
