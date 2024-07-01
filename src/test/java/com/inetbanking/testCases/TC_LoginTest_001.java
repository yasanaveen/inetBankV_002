package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginpagePageObjects;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		
		
		LoginpagePageObjects login= new LoginpagePageObjects(driver);
		login.setuserName(username);
		logger.info("Entered username");
		
		login.setpwd(password);
		logger.info("Entered password");
		login.loginButton();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test  passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
		
		
	}

}
