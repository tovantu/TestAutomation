package com.qa.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.PageBase;
import com.qa.data.HomePageData;
import com.qa.base.CustomBy;


public class HomePage extends PageBase {
	
	
	static Logger log = Logger.getLogger(HomePage.class);

	By closePopup = CustomBy.properties("popup", HomePage.class.getSimpleName());
	By searchFile = CustomBy.properties("searchField", HomePage.class.getSimpleName());
	By logoMain = CustomBy.properties("logoMain", HomePage.class.getSimpleName());
	By productWasView = CustomBy.properties("productWasView", HomePage.class.getSimpleName());
	By imageProductWasView = CustomBy.properties("imageProductWasView", HomePage.class.getSimpleName());
	By CartButton = CustomBy.properties("cartbutton", HomePage.class.getSimpleName());
	By SignInHover = CustomBy.properties("signinhover", HomePage.class.getSimpleName());
	By SignInButton = CustomBy.properties("signinbutton", HomePage.class.getSimpleName());
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public void closePopup() {
		log.info("Click popup");
		click(closePopup);
	}
	public void sendKeySearch() {
		log.info("Send text to search field");
		sendText(searchFile, HomePageData.keySearch);
	}
	public void clickLogo() {
		log.info("Click logoMain");
		click(logoMain);
	}
	public void moveToProductWasView() {
		log.info("Move to Product Was View");
		hoverElement(productWasView);
	}
	public void clickImageProductWasView() {
		click(imageProductWasView);
	}
	public void clickCart() {
		log.info("Send click to Cart button");
		click(CartButton);
	}
	public void HoverSignInButton () {
		log.info("Hover to Sign-in button");
		hoverElement(SignInHover);
	}
	public void clickSignInButton() {
		log.info("Click Sign-in button");
		click(SignInButton);

	}
	public void sendKeyEnter() {
		log.info("Click Enter");
		sendKeyEnter(searchFile);
	}
	
}
