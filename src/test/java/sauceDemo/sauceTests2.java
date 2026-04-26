package sauceDemo;

import PAGES.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sauceTests2 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void sauceDemoTest2() {
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);
        HomePage home = loginPage.loginAs("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnProduct("Sauce Labs Backpack");

        ProductPage productPage = new ProductPage(driver);

        String productName = productPage.getProductName();
        String productPrice = productPage.getProductPrice();

        Assert.assertEquals(productName, "Sauce Labs Backpack");
        Assert.assertEquals(productPrice, "$29.99");

        productPage.addToCart();
        home.goToCart();

        CartPage cartPage = new CartPage(driver);

       boolean isProductInCart = cartPage.isProductInCart("Sauce Labs Backpack");
       Assert.assertTrue(isProductInCart, "Produsul nu este in cos.");
    }
}