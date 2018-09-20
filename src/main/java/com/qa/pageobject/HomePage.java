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


public class HomePage extends PageBase {
	
	static Properties pro;
	public static void ReadProperties(){
		
		pro = new Properties();
		try {
			FileInputStream ip = new FileInputStream("E:\\Github\\TestAutomation\\src\\main\\java\\com\\qa\\pageobject\\properties\\chrome\\homepageChrome.properties");
			pro.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	By closePopup = By.xpath(pro.getProperty("popup"));
	By searchFile = By.xpath(pro.getProperty("searchField"));
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void closePopup() {
		click(closePopup);
	}
	public void sendKeySearch() {
		sendText(searchFile, SearchData.keySearch);
	}
}
