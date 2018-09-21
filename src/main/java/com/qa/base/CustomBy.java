package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

public class CustomBy extends By {

	static Properties pro;
	static Logger log = Logger.getLogger(CustomBy.class);
	
	public static By properties(String xpathExpression, String pageName) {

		String browser = TestBase.pro.getProperty("browser");
		String src = "";
		if(browser.equalsIgnoreCase("chrome")) {
			browser = "Chrome";
			src ="chrome";
		}else if(browser.equalsIgnoreCase("firefox")) {
			browser = "Firefox";
			src ="firefox";
		}
		
		log.info("**************************************read xpath properties**************************************");
		
		pro = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src\\main\\java\\com\\qa\\pageobject\\properties\\"+src+"\\"+ pageName + browser +"Xpath.properties");
			pro.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return new ByXPath(pro.getProperty(xpathExpression));
	}

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
