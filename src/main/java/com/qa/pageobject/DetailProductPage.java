package com.qa.pageobject;

import org.apache.log4j.Logger;

import com.qa.base.CustomBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.PageBase;
import com.qa.data.HomePageData;
import com.qa.base.CustomBy;

public class DetailProductPage extends PageBase {

    static Logger log = Logger.getLogger(DetailProductPage.class);

    //	By closePopup = CustomBy.properties("popup", DetailProductPage.class.getSimpleName());
    By AddtoCartButton = CustomBy.properties("buttonAddtoCart", DetailProductPage.class.getSimpleName());
    By titleDetailProduct = CustomBy.properties("titleDetailProduct", DetailProductPage.class.getSimpleName());

    public DetailProductPage(WebDriver driver) {
        super(driver);
    }

    //	public void closePopup() {
//		log.info("Click popup");
//		click(closePopup);
//	}
    public String getTitleProduct() {
        log.info("Get title product in detail page");
        String text = findElement(titleDetailProduct).getText();
        return text;
    }

    public void sendClick() {
        log.info("Send click to Add to Cart");
        click(AddtoCartButton);
    }

}
