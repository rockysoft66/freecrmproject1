package com.qa.freecrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base{
	Actions act;

	@FindBy(xpath = "//div[@id='top-header-menu']/div[1]")
	WebElement logo;

	@FindBy(xpath = "//div/a[@class ='item' and @href='/home']")
	WebElement homebutton;

	@FindBy(xpath = "//a/span[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(xpath = "//a/span[contains(text(),'Deals')]")
	WebElement deals;
	@FindBy(xpath = "//a/span[contains(text(),'Tasks')]")
	WebElement tasks;



	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public Boolean verfylogo() {

		return logo.isDisplayed();
	}
	
	public ContactsPage veryClickContacts() {

		act  = new Actions(driver);
		act.moveToElement(homebutton).moveToElement(contacts).click().build().perform();
		homebutton.sendKeys(Keys.ESCAPE);
		return new ContactsPage();
	}

	public DealsPage veryClickDeals() {

		act  = new Actions(driver);
		act.moveToElement(homebutton).moveToElement(deals).click().build().perform();
		return new DealsPage();
	}


	public TasksPage veryClickTasks() {

		act  = new Actions(driver);
		act.moveToElement(homebutton).moveToElement(tasks).click().build().perform();
		return new TasksPage();
	}

}
