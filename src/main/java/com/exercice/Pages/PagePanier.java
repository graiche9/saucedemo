package com.exercice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePanier {

    @FindBy(className = "inventory_item_name" )
    private WebElement article;
    WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement Button_Checkout;

    public PagePanier(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getArticleDansLePanier(){
        return article.getText();

    }

    public void clickCheckout(){
        Button_Checkout.click();
    }



}
