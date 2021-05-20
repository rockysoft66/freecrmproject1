package com.qa.freecrm.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.Base;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LogPage;

public class LogPageTest extends Base {
	LogPage logpage;
	HomePage homepage;

	public LogPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialize();
		logpage = new LogPage(); 
	}

	@Test
	public void veryPageTileTest() {

		String title = logpage.veryPageTitle();
		Assert.assertEquals(title, pro.getProperty("title"));
	}	
	
	@Test
	public void veryLoginTest() {
		
		homepage = logpage.verylogin(pro.getProperty("email"), pro.getProperty("password"));
	}
	
	@AfterMethod 
	public void treardown() {
		
		driver.quit();
	}
}
