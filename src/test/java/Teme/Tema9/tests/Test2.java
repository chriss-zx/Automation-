package Teme.Tema9.tests;

import Teme.Tema9.pages.BasePage;
import Teme.Tema9.pages.HomePage;
import Teme.Tema9.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
    WebDriver driver;

    @Test
    public void Test2() {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.openApp();

        BasePage basePage = new BasePage(driver);
        basePage.insertText("pliers");

        homePage.clickOnProduct("Long Nose Pliers");

        ProductPage productPage = new ProductPage(driver);
        String productName = productPage.getProductName();
        System.out.println(productName);
        Assert.assertNotNull(productName, "Numele nu este vizibil.");

        String productPrice = productPage.getPrice();
        double price = Double.parseDouble(productPrice);
        Assert.assertTrue(price > 0, "Pretul nu este mai mare decat 0.");
        System.out.println(productPrice);

    }
}
