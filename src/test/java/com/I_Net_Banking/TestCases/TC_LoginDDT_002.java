package com.I_Net_Banking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.I_Net_Banking.PageObjects.LoginPage;
import com.I_Net_Banking.Utilities.XLUtilies;

public class TC_LoginDDT_002 extends BaseClass //all 3 test cases executing individually ,but at a time 3 test cases are not executing
//all 3 test cases executing individually ,but at a time 3 test cases are not executing
//Channel - SDET- QA Automation Techie
//Tagline - Selenium Hybrid Framework Part-1 | e-Banking Automation Mini Project



{  


	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(user);
		logger.info("user name provided");
		lp.setpassword(pwd);
		logger.info("password provided");
		lp.clickloginsubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();	
		}
		}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
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
	String [][] getData() throws IOException
	{
		//String projectlocation = System.getProperty("user.dir");//this is another way give//channel-Automation Step by Step
		//TAGLINE-Selenium Beginner Tutorial 8 - How to run test on Chrome Browser
//		System.setProperty("webdriver.chrome.driver", projectlocation+"\\Chrome_Driver\\chromedriver.exe");
		//I_Net_Banking/src/test/java/com/I_Net_Banking/TestData
		String path=System.getProperty("user.dir")+"/src/test/java/com/I_Net_Banking/TestData/LoginData.xlsx";
		
		int rownum=XLUtilies.getRowCount(path, "Sheet1");
		int colcount=XLUtilies.getCellCount(path,"Sheet1",1);
		
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtilies.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}