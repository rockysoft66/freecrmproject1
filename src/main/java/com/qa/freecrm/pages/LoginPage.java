package com.qa.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type ='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@class ='navbar-brand']/img")
	WebElement crmprolog;
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifypagetile() {

		return driver.getTitle();
	}
	
	public Boolean verifylog() {
		
		return crmprolog.isDisplayed();
	}
	
	
	
	public HomePage login(String name, String passcode) throws InterruptedException {
		username.sendKeys(name);
		password.sendKeys(passcode);
		loginbutton.click();
		Thread.sleep(40000);
		return new HomePage();
	}
}
