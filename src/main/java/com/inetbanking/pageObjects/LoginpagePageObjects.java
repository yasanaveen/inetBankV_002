package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePageObjects {

	public WebDriver driver;

	public LoginpagePageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	private WebElement userName;


	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(name="btnLogin")
	private WebElement loginbutton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	private WebElement lnkLogout;
	
	
	public void setuserName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void setpwd(String password)
	{
		pwd.sendKeys(password);
	}
	public void loginButton()
	{
		loginbutton.click();
	}

	public void clickLogout()
	{
		lnkLogout.click();
	}
	






}
