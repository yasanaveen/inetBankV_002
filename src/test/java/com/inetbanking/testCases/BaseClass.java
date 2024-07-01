package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig read=new  ReadConfig();

	public String baseURL=read.getApplicationUrl();
	public String username=read.getuserName();
	public String password=read.getpassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(br.equals("firefor"))
		{
			driver= new FirefoxDriver();
		}

		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver,String tname) throws IOException
	{

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/ScreenShots/" +tname + ".png");
		//FileUtil.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}


}
