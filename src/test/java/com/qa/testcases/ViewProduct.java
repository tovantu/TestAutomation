package com.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageobject.DetailProductPage;
import com.qa.pageobject.HomePage;
import com.qa.pageobject.ResultSearchPage;

public class ViewProduct extends TestBase {
	static Logger log = Logger.getLogger(ViewProduct.class);
	
	HomePage homepage ;	
	ResultSearchPage resultSearchPage;
	DetailProductPage detailProductPage;
	
	public  ViewProduct() {
		super();
	}
	
	@Test()
	public void historyViewProduct() throws InterruptedException {
		
		homepage = new HomePage(driver);		
		homepage.closePopup();		
		homepage.sendKeySearch();
		
		Thread.sleep(1000);	
		resultSearchPage = homepage.sendKeyEnter();
		
		Thread.sleep(1000);
		detailProductPage = resultSearchPage.clickProduct();

		ArrayList tabs = new ArrayList (driver.getWindowHandles());
	    driver.switchTo().window((String) tabs.get(1));
	    
		String titlefirst = detailProductPage.getTitleProduct();		
		
		Thread.sleep(1000);
		homepage.clickLogo();
		
		Thread.sleep(1000);
		homepage.moveToProductWasView();
		
		Thread.sleep(1000);
		detailProductPage = homepage.clickImageProductWasView();
		
		Thread.sleep(1000);
		String titlesecond = detailProductPage.getTitleProduct();
		
		Assert.assertEquals(titlesecond, titlefirst);
		
	}
}
