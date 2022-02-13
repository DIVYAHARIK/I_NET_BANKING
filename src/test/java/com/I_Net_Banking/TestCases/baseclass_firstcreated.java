package com.I_Net_Banking.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class baseclass_firstcreated {//first created like this after created utilities it changed like"BaseClass""
	public String baseurl="https://demo.guru99.com/v4/";
	public String uname= "mngr384736";//for generating username and password used mail-divyaqct.auto@gmail.com
	public String pwd="Yguzybe";
	public static WebDriver driver;
	 public static Logger logger;
	 //Logger logger =LogManager.getLogger();
    
	@BeforeTest
	public void setup() {
		//System.getProperty("user.dir")=./[it will use in java classes & in properties//[./ representing home directory//
//       String projectlocation = System.getProperty("user.dir");//this is another way give//channel-Automation Step by Step//TAGLINE-Selenium Beginner Tutorial 8 - How to run test on Chrome Browser
////		System.setProperty("webdriver.chrome.driver", projectlocation+"\\Drivers\\chromedriver.exe");
//		//System.setProperty("webdriver.chrome.driver", projectlocation+"\\Chrome_Driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
//        driver=new ChromeDriver();
//        //driver.get("https://demo.guru99.com/v4/");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\chromedriver\\chromedriver.exe");
		  driver =new ChromeDriver();
		  logger.info("launching  browser");
		 //driver.get("https://demo.guru99.com/v4/");
		 //logger.info("launching demo guru browser");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  Logger logger = Logger.getLogger("log4j.properties");
		  
//	  Logger logger=Logger.getLogger("ebanking");
//	 PropertyConfigurator.configure("log4j.xml");
	} 
	@AfterTest
	public void teardown() {
		
      driver.quit();
	}
}



