package com.nocommercedemo.Pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class DeskTopPage  extends Baseclass   {
	
	
	Action action= new Action(); 
	
	
	@FindBy(xpath = "//a[normalize-space()='HP']")
	WebElement hp_manf;

	@FindBy(xpath = "//a[@title='Grid']")
	WebElement grid;

	@FindBy(xpath = "//a[@title='List']")
	WebElement list;
	
	@FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'HP Envy 6-1180ca 15.6-Inch Sleekbook')]")
	WebElement product_link;
	
	

	// Initialization of page factory:

	public DeskTopPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	

	// Actions:

	public String ValidatedesktopPageTitle() {// GET TITLE OF Desktop PAGE

		return getDriver().getTitle();
	}
	
	
	

	public void cputype() throws InterruptedException {
	
	
	
		hp_manf.click();// click on HP manufacturer
		
		Thread.sleep(2000);
		
		
		// LIST OF ALL CHECKBOXES OF CPU AND MEMORY
		
		List<WebElement> checkboxes = getDriver().findElements(By.xpath("//input[@type='checkbox']"));
		
		
		
		System.out.println("number of ckeckboxex:" + checkboxes.size());
		
		

		// traverse through the list and select all check boxes if they are displayed
		
		// and enabled of CPU type and memory type

		for (int i = 0; i < checkboxes.size(); i++) 
		{
			if (checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled())
			{
				System.out.println("Checkbox is displayed at index : " + i + " Clicking on it now");

				checkboxes.get(i).click();
			}
		}

		System.out.println("de-selecting checkbox with index 0&2");

		checkboxes.get(0).click();// DESELECT CPU TYPE-INTEL CORE i5

		checkboxes.get(2).click();// DESELECT MEMORY TYPE-4GB

		Thread.sleep(2000);
		
		
		// sort by low to high price drop down
		

		Select sortby = new Select(getDriver().findElement(By.xpath("//*[@id=\"products-orderby\"]")));
		
		List<WebElement> allitems1 = sortby.getOptions();

		System.out.println("Dropdown size is:" + allitems1.size());

		for (int i = 0; i < allitems1.size(); i++) 
		{

			System.out.println("list of all items:" + allitems1.get(i).getText());

		}

		sortby.selectByValue("10");// select by low to high price

		Thread.sleep(2000);
		
		
//Items display per page drop down:
		
		
		Select displayperpage = new Select(getDriver().findElement(By.xpath("//select[@id='products-pagesize']")));

		List<WebElement> allitems2 = displayperpage.getOptions();

		System.out.println("Dropdown size is:" + allitems1.size());

		for (int i = 0; i < allitems2.size(); i++) 
		{

			System.out.println("list of all items:" + allitems2.get(i).getText());

		}

		displayperpage.selectByValue("3");// select display per page 3 items
		Thread.sleep(2000);

		grid.click();// SELECT GRID ICON
		Thread.sleep(2000);

		list.click();// SELECT LIST ICON
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
