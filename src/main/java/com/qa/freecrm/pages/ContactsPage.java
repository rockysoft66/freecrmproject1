package com.qa.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends Base {
	
	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement contacttitle;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement Createbutton;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement middlename;
	
	@FindBy(xpath = "//div[@name='company']/input")
	WebElement company;
	
	@FindBy(xpath = "//div/input[@name='value' and @placeholder ='Email address']")
	WebElement email;
	
	@FindBy(xpath = "//div/input[@name='address']")
	WebElement street;
	
	@FindBy(xpath = "//div/input[@name='city']")
	WebElement city;
	@FindBy(xpath = "//div/input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//div/input[@name='zip']")
	WebElement zip;
	
	@FindBy(xpath = "//div/input[@name='department']")
	WebElement department;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement savebutton;
	
	@FindBy(xpath = "//div[@name ='status' and @role ='listbox']")
	WebElement statusdropdown;
	
	@FindBy(xpath = "//div[@name ='status']//span[contains(text(),'Active')]")
	WebElement status;
	
	@FindBy(xpath = "//input[@name ='value' and @placeholder ='Number']")
	WebElement phoneno;
	
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public Boolean veryContactTitle() {
		
		return contacttitle.isDisplayed();
		
	}
	
	public void addContacts(String firsName,String Lastname,String Middlename,String Company,String Email,String Phoneno,String Street,String City,String State,String Zip) throws InterruptedException {
		Createbutton.click();
		firstname.sendKeys(firsName);
		lastname.sendKeys(Lastname);
		middlename.sendKeys(Middlename);
		company.sendKeys(Company);
		email.sendKeys(Email);
		statusdropdown.click();
		status.click();
		phoneno.sendKeys(Phoneno);
		street.sendKeys(Street);
		city.sendKeys(City);
		state.sendKeys(State);
		zip.sendKeys(Zip);
		savebutton.click();
		Thread.sleep(40000);
	}
}
