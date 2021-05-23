package com.qa.freecrm.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPage extends Base {
	
	
	Logger log = Logger.getLogger(LogPage.class);
			
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(xpath = "//div[@class='ui stacked segment']/div[contains(text(),'Login')]")
	WebElement login;
	
	public LogPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String veryPageTitle() {
		
		return driver.getTitle();
	}
	
	public HomePage verylogin(String gmail, String password) {
		log.info(password);
		 email.sendKeys(gmail);
		 pass.sendKeys(password);
		 login.click();
		
		return new HomePage();
	}
}
