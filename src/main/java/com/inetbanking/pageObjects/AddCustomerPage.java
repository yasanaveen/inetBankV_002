package com.inetbanking.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCustomerPage {
	
	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(linkText="New Customer")
	private WebElement clickonnewcustomer;
	
	@FindBy(name = "name")
	private WebElement cName;
	
	@FindBy(id = "dob")
	private WebElement dob;
	
	@FindBy(name = "addr")
	private WebElement address;
	
	@FindBy(name = "city")
	private WebElement cityName;
	
	@FindBy(name = "state")
	private WebElement stateName;
	
	@FindBy(name = "pinno")
	private WebElement pincode;
	
	@FindBy(name = "telephoneno")
	private WebElement mobilenumber;
	
	@FindBy(name = "emailid")
	private WebElement mailId;
	
	@FindBy(name = "password")
	private WebElement pwd;
	
	@FindBy(name = "sub")
	private WebElement submitbutton;
	
	
	
	public void clicknewcustomer()
	{
		clickonnewcustomer.click();
	}
	
	public void custmername(String name)
	{
		cName.sendKeys(name);
	}
	
	public void enterdateofbirth(String date,String mth,String year)
	{
		dob.sendKeys(date);
		dob.sendKeys(mth);
		dob.sendKeys(year);
	}
	
	public void cAdrees(String caddress)
	{
		address.sendKeys(caddress);
	}
	
	public void ccityName(String city)
	{
		cityName.sendKeys(city);
	}
	
	public void stateName(String statename)
	{
		stateName.sendKeys(statename);
	}
	
	public void cpincode(String pin)
	{
		pincode.sendKeys(pin);
	}
	
	public void cmobilenumber(String mob)
	{
		mobilenumber.sendKeys(mob);
	}
	
	public void cmail(String mail)
	{
		mailId.sendKeys(mail);
	}
	
	
	public void cpassword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void submitbutton()
	{
		submitbutton.click();
	}
	

	
	

}
