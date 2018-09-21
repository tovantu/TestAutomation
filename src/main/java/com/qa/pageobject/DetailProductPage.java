package com.qa.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.CustomBy;
import com.qa.base.PageBase;

public class DetailProductPage extends PageBase {

	static Logger log = Logger.getLogger(DetailProductPage.class);
	
	public DetailProductPage (WebDriver driver) {
		super(driver);
	}
	
	By titleDetailProduct = CustomBy.properties("titleDetailProduct", DetailProductPage.class.getSimpleName());
	
	public String getTitleProduct () {
		log.info("Get title product in detail page");
		String text = findElement(titleDetailProduct).getText();
		return text;
	}
	
}
