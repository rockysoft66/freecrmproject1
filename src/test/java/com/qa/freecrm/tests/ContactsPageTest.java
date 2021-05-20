package com.qa.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.Base;
import com.qa.freecrm.pages.ContactsPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LogPage;
import com.qa.freecrm.utils.Utils;

public class ContactsPageTest extends Base{

	LogPage logpage;
	HomePage homepage;
	ContactsPage contactspage;
	public ContactsPageTest() {

		super();

	}
	@BeforeMethod
	public void setup() {

		initialize();
		logpage = new LogPage();
		homepage = logpage.verylogin(pro.getProperty("email"), pro.getProperty("password"));
		contactspage = homepage.veryClickContacts();

	}
	@Test(priority = 2)
	public void veryContactTitleTest() {

		Assert.assertTrue(contactspage.veryContactTitle());
	}

	@DataProvider
	public Object[][] contactTestData(){

		return Utils.testdata(pro.getProperty("sheetname"));


	}
	@Test(priority = 1,dataProvider = "contactTestData" )
	public void addContactsTest(String FirstName,String Lastname,String Middlename,String Company,String Email,String Phoneno,String Street,String City,String State,String Zip) throws InterruptedException {

		contactspage.addContacts(FirstName, Lastname, Middlename, Company, Email, Phoneno, Street, City, State, Zip);



	}
	@AfterMethod
	public void treardown() {

		driver.quit();
	}

}
