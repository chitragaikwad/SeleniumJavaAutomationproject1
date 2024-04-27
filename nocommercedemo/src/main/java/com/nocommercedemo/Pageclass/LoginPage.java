package com.nocommercedemo.Pageclass;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nocommercedemo.Base.Baseclass;
import com.nocommercedemo.actiondriver.Action;

public class LoginPage  extends Baseclass {
	
	
	Action action= new Action();

	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginlink;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement username1;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement password1;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement loginbutton;

	@FindBy(xpath = "//input[@id='RememberMe']")
	WebElement rememberckbox;
	
	
	

	// Initialization of page factory:
	
		public LoginPage() {
			PageFactory.initElements(getDriver(), this);
		}
		

		// Actions:
		
	public String ValidateloginPageTitle() {// GET TITLE OF Login  PAGE
				loginlink.click();
				return getDriver().getTitle();
			}
	
	 public void  Logincredentials(String username, String password) {
				
		            loginlink.click();
					
					username1.clear();
					
                    action.type(username1,username );// enter user name password 
                    
                    password1.clear();
                    
					action.type(password1 , password);  // enter password 

				    rememberckbox.click();  // check the remember password check box

					action.click(getDriver(),loginbutton); // click on login button
					
			}
	}
	

