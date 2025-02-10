package com.exercice.Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;
    @FindBy(css = "#header_container > div.header_secondary_container > div > span > select")
    private WebElement Button_Filtrer;

    @FindBy(css = ("#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)"))
    private WebElement FiltreLowToHight;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div")
    private List<WebElement> ListDePrix;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement Button_add;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductPageUrl(){   
        return driver.getCurrentUrl();   // recuperer l'url current
    }

    public void setfilterLowToHight(){
        Button_Filtrer.click();
        FiltreLowToHight.click();

    }

    public boolean listLowToHight() {
        // je crée une liste vide de type string 
        List<String> list = new ArrayList<>();
        // on cree une boucle pour lire chaque elements de listdeprix pour les ajouter dans la liste 
        // a chaque nouvelle tteration de listeseprix ils s'enregistre dans orderlist
        for(WebElement orderList: ListDePrix){
            list.add(orderList.getText().replaceAll("[^\\d]", ""));
        }

        // iterator= taille de la liste 
        Iterator<String> iterator = list.iterator();
        //convertir le premier element de l'eterator en un entier 
        int current, previous = Integer.parseInt(iterator.next());
        while (iterator.hasNext()) {
            current = Integer.parseInt(iterator.next());
            if(previous>current ){
                return false; 
            }
            previous = current;
        }
        return true;
    }

 public void clicksurButtonAdd(){

    Button_add.click();
 }


}
