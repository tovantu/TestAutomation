package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageobject.HomePage;

public class TestHistoryViewProduct extends TestBase {
	
	HomePage homepage ;
	
	public  TestHistoryViewProduct() {
		super();
	}
	@Test()
	public void historyViewProduct() throws InterruptedException {
		homepage = new HomePage(driver);
		
		homepage.closePopup();
		
		homepage.sendKeySearch();
		Thread.sleep(2000);
	}
}
