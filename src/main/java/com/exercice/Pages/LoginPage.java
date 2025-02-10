package com.exercice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "#user-name")
    private WebElement username;
    
    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#login-button")
    private WebElement login_button;

    WebDriver driver;

// Constructeur 
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void Login(){

        username.click();
        username.sendKeys("standard_user");

        password.click();
        password.sendKeys("secret_sauce");

        login_button.click();
    }




}
