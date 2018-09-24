package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import java.util.ArrayList;

import org.testng.Assert;
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

		log.info("Test*************Close popup");
		homepage.closePopup();

		log.info("Test*************send key search");
		homepage.sendKeySearch();

		log.info("Test*************enter key");
		homepage.sendKeyEnter();

		resultSearchPage = new ResultSearchPage(driver);
		log.info("Test*************click to product");
		resultSearchPage.ClickProduct();


		log.info("Test*************handle window");
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1));

		detailProductPage = new DetailProductPage(driver);
		log.info("Test*************get titile product first");
		String titlefirst = detailProductPage.getTitleProduct();
		driver.close();
		driver.switchTo().window((String) tabs.get(0));

		log.info("Test*************click logo menu");
		homepage.clickLogo();

		log.info("Test*************Move to product was view");
		homepage.moveToProductWasView();

		log.info("Test*************click into image product was view");
		homepage.clickImageProductWasView();

		log.info("Test*************get titile product second");
		String titlesecond = detailProductPage.getTitleProduct();

		log.info("Test*************Verify title product");
		Assert.assertEquals(titlesecond, titlefirst);

	}
}
