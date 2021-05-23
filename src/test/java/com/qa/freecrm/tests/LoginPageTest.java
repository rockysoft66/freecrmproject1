package com.qa.freecrm.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.freecrm.pages.Base;
import com.qa.freecrm.pages.HomePage;
import com.qa.freecrm.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		
		super();
		
	}
	
	
	@BeforeMethod
	public void setup()  {
		
		initialize();
		loginpage = new LoginPage();
			
	}
	
	@Test(priority = 1, description = "Verify page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case Description verify login page title")
	@Story("StoryName:To check Login page title ")
	public void verifypagetiletest() {
		
	String title =	loginpage.verifypagetile();
	System.out.println("PageTitle"+title);
	Assert.assertEquals(title.trim(), pro.getProperty("title"));
	}
	
	@Test(priority = 2, description = "verifyLogTest")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case Description verify Log dispalyed")
	@Story("StoryName:To check Log dispalyed ")
	public void verifyLogTest() {
		
		Assert.assertTrue(loginpage.verifylog());
		
	}
	@Test(priority = 3, description = "verfyLoginPageTest")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case Description verify login")
	@Story("StoryName:To check Login  ")
	public void verfyLoginPageTest() throws InterruptedException {
		
		homepage =	loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@AfterMethod 
	public void treardown() {
		driver.quit();
	}
	

}
