package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() 
	{
		
		
		
		try {
			File src = new File("./configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		
		}catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationUrl()
	{
		String url=pro.getProperty("ApplicationUrl");
		return url;
	}

	public String getuserName()
	{
		String userName=pro.getProperty("username");
		return userName;
	}

	public String getpassword()
	{
		String Password=pro.getProperty("password");
		return Password;
	}







}
