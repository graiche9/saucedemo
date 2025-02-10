package com.exercice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {
 @FindBy(css = "#first-name")
 private WebElement First_Name;
 @FindBy(css="#last-name")
 private WebElement Last_Name;
 @FindBy(css="#postal-code")
 private WebElement CodePostal;
@FindBy(css = "#continue")
private WebElement Button_Continue;



   WebDriver driver;

        public checkoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getURLcheckoutPage(){
         return driver.getCurrentUrl();
    }

    public void remplir_form(){

        First_Name.sendKeys("Fazia");

        Last_Name.sendKeys("GRAICHE");

        CodePostal.sendKeys("25000");

  
    }
    public void ButtonContinue(){
        Button_Continue.click();
    }
}
