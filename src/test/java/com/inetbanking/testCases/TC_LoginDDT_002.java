package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginpagePageObjects;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String password) throws InterruptedException
	{
		LoginpagePageObjects lp= new LoginpagePageObjects(driver);
		lp.setuserName(username);
		logger.info("username entered");
		lp.setpwd(password);
		logger.info("password entered");
		lp.loginButton();
		
//		lp.clickLogout();
//		logger.info("Log outed...");
		
		Thread.sleep(4000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login passed");
			lp.clickLogout();
			logger.warn("Application logout..");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
	
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		 driver.switchTo().alert();
		 return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][]getData() throws IOException
	{
		
		String path= "C:\\eclipse-workspace\\inetbankingv2\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		int columncount=XLUtils.getCellCount(path, "Sheet1",1);
		
		String loginData[][]= new String[rowcount][columncount];	
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	
	
	
	
}
