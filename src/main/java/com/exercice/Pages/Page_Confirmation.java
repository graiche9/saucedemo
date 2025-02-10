package com.exercice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Confirmation {
@FindBy(css = "#checkout_complete_container > h2" )
private WebElement titreConfirmation;
    
       WebDriver driver;

        public Page_Confirmation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getURLwebPage(){
         return driver.getCurrentUrl();
    }

    public String getTitreConfirmation(){
        return titreConfirmation.getText();
    }
}
