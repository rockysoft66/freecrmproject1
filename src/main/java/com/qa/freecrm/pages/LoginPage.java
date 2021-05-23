package com.qa.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

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
	@Step("getting login page title step ..")
	public String verifypagetile() {

		return driver.getTitle();
	}
	@Step("Verfy login page log displayed step ..")
	public Boolean verifylog() {
		
		return crmprolog.isDisplayed();
	}
	
	
	@Step("login with username:{0} and password :{1} step ..")
	public HomePage login(String name, String passcode) throws InterruptedException {
		username.sendKeys(name);
		password.sendKeys(passcode);
		loginbutton.click();
		Thread.sleep(40000);
		return new HomePage();
	}
}
