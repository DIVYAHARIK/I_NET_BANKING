package com.I_Net_Banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.I_Net_Banking.PageObjects.AddCustomerPage;
import com.I_Net_Banking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 

//all 3 test cases executing individually ,but at a time 3 test cases are not executing
//Channel - SDET- QA Automation Techie
//Tagline - Selenium Hybrid Framework Part-1 | e-Banking Automation Mini Project
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(uname);
		logger.info("User name is provided");
		lp.setpassword(pwd);
		logger.info("Passsword is provided");
		lp.clickloginsubmit();
		
		Thread.sleep(5000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}