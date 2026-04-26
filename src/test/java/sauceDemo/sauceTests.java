package sauceDemo;

import PAGES.HomePage;
import PAGES.InventoryPage;
import PAGES.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class sauceTests {

    WebDriver driver = new ChromeDriver();

    @Test
    public void sauceDemoTest() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.loginAs("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        System.out.println("Pe pagina sunt: " + inventoryPage.getProductsCount() + " produse.");

        List<WebElement> listaProduse = inventoryPage.getAllProducts();

        System.out.println("Lista de produse: ");
        for(WebElement produs : listaProduse) {
            System.out.println(produs.getText());
        }

        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProductToCart("Sauce Labs Onesie");

//        homePage.clickLogoutButton();
    }
}
