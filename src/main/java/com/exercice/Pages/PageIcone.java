package com.exercice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIcone {

    WebDriver driver;
    @FindBy(id = "shopping_cart_container")
    private WebElement panier;


    public PageIcone(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean articleAjouteAuPanier(){
        if (panier.getText().equals("1")){
          
            return true;  
        }
        
        else {
            return false ;
        }
    }

    public void ClickSurPanier(){
        panier.click();
    }
}
