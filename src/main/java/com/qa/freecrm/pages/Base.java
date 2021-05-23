package com.qa.freecrm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	static public Properties pro;
	static public FileInputStream ip;
	static public WebDriver driver;
	
	public Base() {
		
		 pro = new Properties();
		try {
			 ip = new FileInputStream(new File ("C:\\Users\\dssri\\eclipse-workspace\\project\\src\\main\\java\\com\\qa\\freecrm\\config\\config.properties"));
			pro.load(ip); 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialize()  {
		
		String browser = pro.getProperty("browser");
		
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			MutableCapabilities soucelab = new MutableCapabilities();
			//soucelab.setCapability("name",method);
			soucelab.setCapability("build", "java-w3c-Examples");
			soucelab.setCapability("seleniumVersion", "3.141.59");
			soucelab.setCapability("username", pro.getProperty("sourcelabusername"));
			//soucelab.setCapability("password", pro.getProperty("sourcelabpassword"));
			soucelab.setCapability("accessKey", pro.getProperty("sourcelabkey"));		
			soucelab.setCapability("build", "w3c-chrome-tests");

			ChromeOptions browserOptions = new ChromeOptions();
		//	browserOptions.setExperimentalOption("w3c", true);
			browserOptions.setCapability("platformName", "Windows 10");
			browserOptions.setCapability("browserVersion", "latest");
			browserOptions.setCapability("sauce:options", soucelab);

			
			
			
//			
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setBrowserName("chrome");
//			cap.setPlatform(Platform.LINUX);
						
			
			//String hubUrl =  "http://192.168.10.101:4444/wd/hub";
			try {
				driver = new RemoteWebDriver(new URL(pro.getProperty("urls")),browserOptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		
		
	}
	
	

}
