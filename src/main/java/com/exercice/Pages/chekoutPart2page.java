package com.exercice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class chekoutPart2page {
@FindBy(css = "#item_0_title_link > div ")
private WebElement titre_article;
@FindBy(css = "#checkout_summary_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div")
private WebElement prix_Article;
@FindBy(css ="#checkout_summary_container > div > div.summary_info > div.summary_total_label")
private WebElement prix_Total;
@FindBy(css = "#finish")
private WebElement Button_Finish;

       WebDriver driver;

        public chekoutPart2page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getURLwebPage(){
         return driver.getCurrentUrl();
    }

    public String getTitreDElarticle(){
        return titre_article.getText();
    }
    public String getPrix(){
        return prix_Article.getText();
 
    }

    public String getPrixTotal(){

        return prix_Total.getText();
    }

    public void click_finish_Button(){
    
    Button_Finish.click();
    } 
}
