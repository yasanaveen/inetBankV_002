package com.inetbanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginpagePageObjects;

public class TC_AddCustomerTest_003 extends BaseClass{


	@Test
	public void addCustomer() throws InterruptedException
	{

		LoginpagePageObjects login=new LoginpagePageObjects(driver);

		login.setuserName(username);
		logger.info("username entered...");
		login.setpwd(password);
		logger.info("password entered..");
		login.loginButton();

		AddCustomerPage addcust= new AddCustomerPage(driver);
		addcust.clicknewcustomer();
		Thread.sleep(3000);
		logger.info("customerdetails entered...");
		addcust.custmername("Naveen naidu");
		Thread.sleep(3000);
		addcust.enterdateofbirth("21", "12", "1997");
		addcust.cAdrees("Hyderabad");
		Thread.sleep(3000);
		addcust.ccityName("Hyderabad");
		addcust.stateName("TG");
		addcust.cpincode("507305");
		addcust.cmobilenumber("8008263110");
		addcust.cmail("yasanaveen5@gmail.com");
		addcust.cpassword("NaveenYasa");
		Thread.sleep(3000);
		addcust.submitbutton();
		
		driver.switchTo().alert().accept();

		Thread.sleep(3000);


		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
           Assert.assertTrue(true);
           logger.info("Testcase passed..");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Testcase failed..");
		}

	}


}
