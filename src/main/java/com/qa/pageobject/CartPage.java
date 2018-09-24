package com.qa.pageobject;

import com.qa.base.CustomBy;
import com.qa.base.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {
    static Logger log = Logger.getLogger(CartPage.class);

    By titleProduct = CustomBy.properties("titleProduct",CartPage.class.getSimpleName());

    public CartPage(WebDriver driver){
        super(driver);
    }
    public String getTitle(){
        String title =findElement(titleProduct).getText();
        return title;
    }
}
