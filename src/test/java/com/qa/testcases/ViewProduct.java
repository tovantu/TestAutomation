package com.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

	HomePage homepage;
	ResultSearchPage resultSearchPage;
	DetailProductPage detailProductPage;

	public ViewProduct() {
		super();
	}

	@Test()
	public void historyViewProduct() throws InterruptedException {

		homepage = new HomePage(driver);
		
		log.info("Close popup");
		homepage.closePopup();
		
		log.info("send key search");
		homepage.sendKeySearch();
		
		log.info("enter key");
		resultSearchPage = homepage.sendKeyEnter();
		
		log.info("click to product");
		detailProductPage = resultSearchPage.clickProduct();
		
		log.info("handle window");
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));
		
		log.info("get titile product first");
		String titlefirst = detailProductPage.getTitleProduct();
		driver.close();
		driver.switchTo().window((String) tabs.get(0));
		
		log.info("click logo menu");
		homepage.clickLogo();
		
		log.info("Move to product was view");
		homepage.moveToProductWasView();
		
		log.info("click into image product was view");
		detailProductPage = homepage.clickImageProductWasView();
		
		log.info("get titile product second");
		String titlesecond = detailProductPage.getTitleProduct();
		
		log.info("Verify title product");
		Assert.assertEquals(titlesecond, titlefirst);

	}
}
