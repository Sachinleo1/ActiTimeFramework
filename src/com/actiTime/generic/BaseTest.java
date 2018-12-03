package com.actiTime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	
	public WebDriver driver;
	
	 
	
	@BeforeMethod
	public void preCondition() 
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		
	}
	
	
	
	
	
	@AfterMethod
	public void postCondition() 
	{
	driver.close();
	}
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Title is Matching"+eTitle,true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is Not Matching",true);
			Assert.fail();
		}
	}
	

}
