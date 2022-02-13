package com.I_Net_Banking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.I_Net_Banking.Utilities.ReadConfig;

import org.testng.annotations.AfterTest;

public class BaseClass  {
	ReadConfig readConfig =  new ReadConfig();
	
	
	public String baseurl=readConfig.getApplicationurl();
	public String uname= readConfig.getusername();//for generating username and password used mail-divyaqct.auto@gmail.com
	public String pwd=readConfig.getpassword();
	public static WebDriver driver;
	
	
//	public String baseurl="https://demo.guru99.com/v4/";
//	public String uname= "mngr384736";//for generating username and password used mail-divyaqct.auto@gmail.com
//	public String pwd="Yguzybe";
//	public static WebDriver driver;
	 
	
	public static Logger logger;
	 //Logger logger =LogManager.getLogger();
    @Parameters("browser")
	@BeforeTest
	public void setup(String br) {
		
		logger=Logger.getLogger("log4j2.properties");
		PropertyConfigurator.configure("log4j2.properties");
		
		 //DOMConfigurator.configure("log4j.xml");//for xml
		
		//System.getProperty("user.dir")=./[it will use in java classes & in properties//[./ representing home directory//
//       String projectlocation = System.getProperty("user.dir");//this is another way give//channel-Automation Step by Step//TAGLINE-Selenium Beginner Tutorial 8 - How to run test on Chrome Browser
////		System.setProperty("webdriver.chrome.driver", projectlocation+"\\Drivers\\chromedriver.exe");
//		//System.setProperty("webdriver.chrome.driver", projectlocation+"\\Chrome_Driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
//        driver=new ChromeDriver();
//        //driver.get("https://demo.guru99.com/v4/");
		
		if (br.equals("chrome")) 
		{
			
		
		System.setProperty("webdriver.chrome.driver",readConfig.getchromepath());
		  driver =new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getfirefoxpath());
			  driver =new FirefoxDriver();
			}
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readConfig.getiepath());
			  driver =new InternetExplorerDriver();
			}
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get(baseurl);
		  logger.info("launching  browser");
		 driver.get("https://demo.guru99.com/v4/");
		 logger.info("launching demo guru browser");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
	  
	  //Logger logger = Logger.getLogger("log4j.xml");
		  
//	  Logger logger=Logger.getLogger("ebanking");
//	 PropertyConfigurator.configure("log4j.xml");
	} 
	@AfterTest
	public void teardown() {
		
      driver.quit();
	}


public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}

public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}


}
