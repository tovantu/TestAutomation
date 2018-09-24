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

public class ResultSearchPage extends PageBase {

	static Logger log = Logger.getLogger(ResultSearchPage.class);
	

	By titleProduct = CustomBy.properties("titleProduct", ResultSearchPage.class.getSimpleName());


	public ResultSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle () {
		log.info("Get Product Name");
		String text = findElement(titleProduct).getText();
		return text;
	}
	
	public void ClickProduct () {
		log.info("Click product");
		click(titleProduct);
		
	}

	
}
