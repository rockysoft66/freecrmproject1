package com.qa.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.Base;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;

public class LoginPageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		
		initialize();
		loginpage = new LoginPage();
			
	}
	
	@Test(priority = 1)
	public void verifypagetiletest() {
		
	String title =	loginpage.verifypagetile();
	System.out.println("PageTitle"+title);
	Assert.assertEquals(title.trim(), pro.getProperty("title"));
	}
	
	@Test(priority = 2)
	public void verifyLogTest() {
		
		Assert.assertTrue(loginpage.verifylog());
		
	}
	@Test(priority = 3)
	public void verfyLoginPageTest() throws InterruptedException {
		
		homepage =	loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@AfterMethod 
	public void treardown() {
		driver.quit();
	}
	

}
