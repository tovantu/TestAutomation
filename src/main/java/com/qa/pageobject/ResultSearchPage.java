package com.qa.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.CustomBy;
import com.qa.base.PageBase;

public class ResultSearchPage extends PageBase {

	static Logger log = Logger.getLogger(ResultSearchPage.class);
	
	
	public ResultSearchPage(WebDriver driver) {
		super(driver);
	}
	
	By titleProduct = CustomBy.properties("titleProduct", ResultSearchPage.class.getSimpleName());
	
	public DetailProductPage clickProduct() {
		log.info("click product in result Search");
		click(titleProduct);;
		return new DetailProductPage(driver);
		
	}
	
	
	
	
}
