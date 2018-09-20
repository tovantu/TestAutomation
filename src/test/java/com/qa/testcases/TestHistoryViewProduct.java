package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageobject.HomePage;

public class TestHistoryViewProduct extends TestBase {
	
	HomePage homepage;
	
	public  TestHistoryViewProduct() {
		super();
	}
	@Test()
	public void historyViewProduct() throws InterruptedException {
		homepage = new HomePage();
		Thread.sleep(1000);
		homepage.closePopup();
		Thread.sleep(2000);
		homepage.sendKeySearch();
	}
}
