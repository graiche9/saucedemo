package com.exercice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.exercice.Pages.LoginPage;
import com.exercice.Pages.PageIcone;
import com.exercice.Pages.PagePanier;
import com.exercice.Pages.Page_Confirmation;
import com.exercice.Pages.PageIcone;
import com.exercice.Pages.ProductPage;
import com.exercice.Pages.checkoutPage;
import com.exercice.Pages.chekoutPart2page;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ExoSauceDemo {

    static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.get("https://saucedemo.com/");
    }

    @Test
    public void T001_Login(){
        LoginPage objectLoginPage = new LoginPage(driver);
        objectLoginPage.Login();  

        ProductPage objetProductPage = new ProductPage(driver);
        Assertions.assertTrue(objetProductPage.getProductPageUrl().contains("inventory.html"), "erreur: la page de produits n'a pas été chargée ");
    }

    @Test
    public void T002_FiltreAvec_Prix(){
        ProductPage objetProductPage = new ProductPage(driver);  
        objetProductPage.setfilterLowToHight();
        Assertions.assertTrue(objetProductPage.listLowToHight(), "la liste n'a pas été triée correctement ");

    }

    @Test
    public void T003_ajouter_un_article_aupanier(){
        ProductPage objectProductPage = new ProductPage(driver);
        PageIcone objectIconePanier = new PageIcone(driver);
        objectProductPage.clicksurButtonAdd();
        Assertions.assertTrue(objectIconePanier.articleAjouteAuPanier(), "le panier ne contient pas un seul element ");

    }

    @Test
    public void T004_Verification_DuPanier(){
        PageIcone objectIconePanier = new PageIcone(driver);
        objectIconePanier.ClickSurPanier();
        PagePanier objetPagePanier = new PagePanier(driver);
        Assertions.assertEquals(objetPagePanier.getArticleDansLePanier(), "Sauce Labs Bike Light",  "l'article dans le panier n'est pas celui attendu ");
        objetPagePanier.clickCheckout();
    }

    @Test 
    public void T005_checkout(){
        checkoutPage objetChekoutPage = new checkoutPage(driver);
        Assertions.assertTrue(objetChekoutPage.getURLcheckoutPage().contains("checkout-step-one.html"), "erreur le lien est faux ");
        objetChekoutPage.remplir_form();
        objetChekoutPage.ButtonContinue();
             
    }
    @Test 
    public void T006_confirmation_informations(){
        chekoutPart2page objetcheckoutPart2page = new chekoutPart2page(driver);
        Assertions.assertTrue(objetcheckoutPart2page.getURLwebPage().contains("checkout-step-two.html"), "lien faux ");
        Assertions.assertTrue(objetcheckoutPart2page.getTitreDElarticle().contains("Bike Light") && objetcheckoutPart2page.getPrix().contains("9.99") && objetcheckoutPart2page.getPrixTotal().contains("10.79") );
        objetcheckoutPart2page.click_finish_Button();

    }   

    @Test
    public void T007_ConfirmationPaiement(){
        Page_Confirmation objetPageConfirmation = new Page_Confirmation(driver);
        Assertions.assertTrue(objetPageConfirmation.getURLwebPage().contains("checkout-complete.html"), "URL faux ");
        Assertions.assertTrue(objetPageConfirmation.getTitreConfirmation().equals("Thank you for your order!"));
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
