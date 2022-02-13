package com.I_Net_Banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.I_Net_Banking.TestCases.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver ldriver;//local driver

	public LoginPage(WebDriver rdriver){//remote driver
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}//@CacheLookup is optional
	@FindBy(name="uid") WebElement username;//@CacheLookup is optional
	@FindBy(name="password") WebElement pword;
	@FindBy(name="btnLogin") WebElement login;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")WebElement lnkLogout;
	
	

	public void setusername(String uname) {
		username.sendKeys(uname);
	}
	public void setpassword(String pwd) {
		pword.sendKeys(pwd);
	}
	public void clickloginsubmit() {
		login.click();;
	}
	public void clickLogout()
	{
		lnkLogout.click();

}}
