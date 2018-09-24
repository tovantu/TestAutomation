package com.qa.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.PageBase;
import com.qa.data.HomePageData;
import com.qa.base.CustomBy;
import com.qa.data.SignInData;


public class SignInPage extends PageBase{
	static Logger log = Logger.getLogger(SignInPage.class);
	
	By SignInField = CustomBy.properties("signinfield", SignInPage.class.getSimpleName());
	By PasswordField = CustomBy.properties("passwordfield", SignInPage.class.getSimpleName());
	By SubmitAccount = CustomBy.properties("submitaccountbutton", SignInPage.class.getSimpleName());
	
	
	public SignInPage (WebDriver driver) {
		super(driver);
	}
	
	public void InputSignIn () {
		log.info("Send text to Sign-in field");
		sendText(SignInField, SignInData.account);
	}
	
	public void InputPassword () {
		log.info("Send text to Password field");
		sendText(PasswordField, SignInData.password);
	}
	public void ClickSubmitAccount () {
		log.info("Click Sign-in to account");
		click(SubmitAccount);
	}
}
