package com.qa.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.PageBase;
import com.qa.data.SearchData;
import com.qa.base.CustomBy;


public class HomePage extends PageBase {
	
	static Properties pro;
	

	By closePopup = CustomBy.properties("popup", HomePage.class.getSimpleName());
	By searchFile = CustomBy.properties("searchField", HomePage.class.getSimpleName());
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public void closePopup() {
		log.info("**************************************click popup**************************************");
		click(closePopup);
	}
	public void sendKeySearch() {
		log.info("**************************************send text to search field**************************************");
		sendText(searchFile, SearchData.keySearch);
	}
}
