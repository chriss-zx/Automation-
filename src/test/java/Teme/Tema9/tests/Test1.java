package Teme.Tema9.tests;

import Teme.Tema9.pages.CartPage;
import Teme.Tema9.pages.HomePage;
import Teme.Tema9.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;

    @Test
    public void test1() {
        driver = new ChromeDriver();

    HomePage homePage = new HomePage(driver);
    homePage.openApp();

        homePage.clickOnProduct("Bolt Cutters");

        ProductPage productPage = new ProductPage(driver);
        System.out.println(productPage.getProductInfo());

        System.out.println(productPage.getProductName());
        System.out.println(productPage.getPrice());
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        String productInCart = cartPage.isProductInCart("Bolt Cutters ");
        Assert.assertEquals(productInCart, "Bolt Cutters ", "Produsul nu este in cos.");
        System.out.println(productInCart);
    }
}
