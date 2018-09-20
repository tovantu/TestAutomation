package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageBase {
	
	WebDriver driver;
	
	public WebElement findElement (By element) {
		return driver.findElement(element);
	}
	public void hoverElement(By element) {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(element)).build().perform();		
	}
	public void sendText(By element, String text) {
		findElement(element).clear();
		findElement(element).sendKeys(text);
	}
	public void click(By element) {		
		findElement(element).click();
	}
}
