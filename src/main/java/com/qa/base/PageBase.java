package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageBase {
	
	public WebDriver driver;
	static Properties pro;
	public static Logger log = Logger.getLogger(PageBase.class);
	
	public PageBase(WebDriver driver) {

		this.driver = driver;
		
	}
	
	
	public WebElement findElement (By element) {
		return driver.findElement(element);
	}
	
	public WebElement findElement (String element) {
		return driver.findElement(By.xpath(pro.getProperty(element)));
	}
	
	public void hoverElement(By element) {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(element)).build().perform();		
	}
	
	public void hoverElement(String element) {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(element)).build().perform();		
	}
	
	public void sendText(By element, String text) {
		findElement(element).clear();
		findElement(element).sendKeys(text);
	}
	
	public void sendText(String element, String text) {
		findElement(element).clear();
		findElement(element).sendKeys(text);
	}
	
	public void click(By element) {		
		findElement(element).click();
	}
	
	public void click(String element) {		
		findElement(element).click();
	}
}
