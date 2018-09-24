package com.qa.testcases;

import java.util.ArrayList;

import com.qa.pageobject.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class TestAddtoCart extends TestBase {

	static Logger log = Logger.getLogger(TestAddtoCart.class);

	HomePage homepage;
	DetailProductPage detailproductpage;
	ResultSearchPage resultsearchpage;
	SignInPage signinpage;
	CartPage cartPage ;

	public  TestAddtoCart() {
		super();
	}

	@Test()
	public void AddtoCart() throws InterruptedException {

		homepage = new HomePage(driver);
		log.info("Close Popup");
		homepage.closePopup();
		log.info("Hover Sign-in button");
		homepage.HoverSignInButton();
		homepage.clickSignInButton();
		signinpage = new SignInPage(driver);
		
		signinpage.InputSignIn();
		log.info("sendkey");

		signinpage.InputPassword();

		signinpage.ClickSubmitAccount();
		Thread.sleep(1000);
		homepage.sendKeySearch();

		homepage.sendKeyEnter();
		resultsearchpage = new ResultSearchPage(driver);
//		Thread.sleep(2000);
		log.info("before close popup");
		homepage.closePopup();


		log.info("before click product");
//		driver.switchTo().frame("fancybox-frame1537759288718");
		resultsearchpage.ClickProduct();

		String titleProdcut = resultsearchpage.getTitle().substring(0,10);
		ArrayList array = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) array.get(1));
		log.info("before new page");
		detailproductpage = new DetailProductPage(driver);
		log.info("before click add to card");
		detailproductpage.sendClick();
		Thread.sleep(1000);
		log.info("before click cart button");
		homepage.clickCart();
		Thread.sleep(1000);
		cartPage = new CartPage(driver);
		String titleProductInCartPage = cartPage.getTitle().substring(0,10);
		log.info(titleProdcut);
		log.info(titleProductInCartPage);
//		Assert.assertEquals(titleProductInCartPage,titleProdcut);
		
	}
}
