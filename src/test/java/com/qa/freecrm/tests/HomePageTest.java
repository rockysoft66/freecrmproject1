package com.qa.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.Base;
import com.qa.freecrm.pages.ContactsPage;
import com.qa.freecrm.pages.DealsPage;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LogPage;
import com.qa.freecrm.pages.TasksPage;

public class HomePageTest extends Base {
	LogPage logpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	
	public HomePageTest() {
		
		super();
	}
	@BeforeMethod
	public void setup() {
		initialize();
		logpage = new LogPage();
		homepage = logpage.verylogin(pro.getProperty("email"), pro.getProperty("password"));
		
	}
	
	@Test
	public void veryLogTest() {
		Assert.assertTrue(homepage.verfylogo());
		
	}
	@Test
	public void veryClickcontactsTest() {
		contactspage = homepage.veryClickContacts();
	}
	
	@Test
	public void veryClickDealsTest() {
		dealspage = homepage.veryClickDeals();
	}
	
	@Test
	public void veryClickTasksTest() {
		taskspage = homepage.veryClickTasks();
	}
	
	@AfterMethod
	public void treardown() {
		driver.quit();
	}

}
