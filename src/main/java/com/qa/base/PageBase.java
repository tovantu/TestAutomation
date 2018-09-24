package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase extends TestBase{
	
//	public WebDriver driver;
	static Properties pro;
	static Logger log = Logger.getLogger(PageBase.class);
	private static final int waitTime = 20;
	
	public PageBase(WebDriver driver) {

//		this.driver = driver;
		
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
		waitForElementToBeClickable(findElement(element));
		findElement(element).click();
	}
	
	public void click(String element) {		
		findElement(element).click();
	}

	public void scrollToElement(By element){
		WebElement ele = findElement(element);
		JavascriptExecutor js =  (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void sendKeyEnter(By element){
		findElement(element).sendKeys(Keys.ENTER);
	}

	public void waitForVisibleElement(WebElement element, String elementName) {
		log.info("+++ Wait For Visible Element: " + elementName);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
//		public void waitForVisibleElement(WebElement element, String elementName) {
//		log.info("+++ Wait For Visible Element: " + elementName);
//		WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
//
//	public void waitForClickableOfElement(WebElement element, String elementName) {
//		log.info("+++ Wait For Clickable Of Element: " + elementName);
//		WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
//
//	public boolean waitForAttributeValueChanged(WebElement element, String elementName, String attributeName,
//			String attributeValue) {
//		logger.info("Try to waitForAtrributeValueChanged: " + elementName);
//		try {
//			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//			wait.until(new ExpectedCondition<Boolean>() {
//				public Boolean apply(WebDriver driver) {
//					String actualAttributeValue = null;
//					if (element.getAttribute(attributeName) != null) {
//						actualAttributeValue = element.getAttribute(attributeName);
//						logger.info("Actual Displayed Value: " + actualAttributeValue);
//					} else {
//						logger.info(String.format("Attribute %s is null", attributeName));
//						return false;
//					}
//					if (actualAttributeValue.equals(attributeValue))
//						return true;
//					else
//						return false;
//				}
//			});
//			return true;
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			return false;
//		}
//	}
	
}
