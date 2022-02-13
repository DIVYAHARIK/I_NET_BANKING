package com.I_Net_Banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.I_Net_Banking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	//all 3 test cases executing individually ,but at a time 3 test cases are not executing
	//Channel - SDET- QA Automation Techie
	//Tagline - Selenium Hybrid Framework Part-1 | e-Banking Automation Mini Project
    @Test
	public void logintest() throws IOException {
		
	driver.get(baseurl);
	logger.info("url is opened");
		
		LoginPage lp= new LoginPage(driver);
		lp.setusername(uname);
		logger.info("entered username");
		lp.setpassword(pwd);
		logger.info("entered password");
		lp.clickloginsubmit();
		//after login verifying homepage 
		//if (driver.getTitle().equals("baGuru99 Bank Manager HomePage1214")) //if we given fail condition screenshot will attach to the extent report
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed ");
		}
		else 
		{
			captureScreen(driver, "logintest");
			Assert.assertTrue(false);
			logger.info("login test failed ");
		}
	}
	
	
	
	
	
	
}
