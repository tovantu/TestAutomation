package com.qa.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.PageBase;
import com.qa.data.HomePageData;
import com.qa.base.CustomBy;


public class HomePage extends PageBase  {
	
	
	static Logger log = Logger.getLogger(HomePage.class);

	By closePopup = CustomBy.properties("popup", HomePage.class.getSimpleName());
	By searchField = CustomBy.properties("searchField", HomePage.class.getSimpleName());
	By logoMain = CustomBy.properties("logoMain", HomePage.class.getSimpleName());
	By productWasView = CustomBy.properties("productWasView", HomePage.class.getSimpleName());
	By imageProductWasView = CustomBy.properties("imageProductWasView", HomePage.class.getSimpleName());
	

	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public void closePopup() {
		log.info("**************************************click popup**************************************");
		click(closePopup);
		
	}
	public void sendKeySearch() {
		log.info("**************************************send text to search field**************************************");
		sendText(searchField, HomePageData.keySearch);
	}
	public void clickLogo() {
		log.info("Click logoMain");
		click(logoMain);
	}
	public void moveToProductWasView() {
		log.info("Move to Product Was View");
		hoverElement(productWasView);
	}
	public DetailProductPage clickImageProductWasView() {
		log.info("click image product was view");
		click(imageProductWasView);
		return new DetailProductPage(driver);
	}
	public ResultSearchPage sendKeyEnter() {
		log.info("enter");
		sendKeyEnter(searchField);
		return new ResultSearchPage(driver);
	}
	
}
