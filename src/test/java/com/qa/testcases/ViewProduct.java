package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageobject.HomePage;

public class ViewProduct extends TestBase {
	static Logger log = Logger.getLogger(ViewProduct.class);
	
	HomePage homepage ;	
	
	public  ViewProduct() {
		super();
	}
	
	@Test()
	public void historyViewProduct() throws InterruptedException {
		
		homepage = new HomePage(driver);
		log.info("**************************************Close Popup**************************************");
		homepage.closePopup();
		log.info("**************************************Send Text**************************************");
		homepage.sendKeySearch();
		Thread.sleep(2000);
	}
}
