package com.actiTime.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LoginLogoutPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test
	public void testValidLoginLogout() throws InterruptedException
	{
		String user = ExcelData.getData("./data/input.xlsx", "Sheet1", 1, 2);
		String pass = ExcelData.getData("./data/input.xlsx", "Sheet1", 1, 3);
		String loginTitle = ExcelData.getData("./data/input.xlsx", "Sheet1", 1, 0);
		String enterTimeTrackTitle = ExcelData.getData("./data/input.xlsx", "Sheet1", 1, 1);
		
		LoginLogoutPage lp = new LoginLogoutPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		
		//verify the login page
		lp.verifyPage(loginTitle);
		
		//enter valid username
		Reporter.log("valid username: "+user,true);
		lp.enterUserName(user);
				
		//enter valid password
		Reporter.log("Valid password: "+pass,true);
		lp.enterPassword(pass);
		
		//click on login
		Reporter.log("Login: ",true);
		lp.clickOnLogin();
		
		
		//verify the enter time track page
		lp.verifyPage(enterTimeTrackTitle);
		
		//click on logout
		Thread.sleep(2000);
		Reporter.log("Logout: ",true);
		ep.clickOnLogout();
		
		
		//verify the login page
		lp.verifyPage(loginTitle);
	}
}
