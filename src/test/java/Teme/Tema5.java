package Teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Tema5 {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

//    1. Folosind pagina https://practicesoftwaretesting.com/
//    Accesează o categorie de produse.
//    Folosește filtrele disponibile.
//    Selectează un filtru (ex: brand).
//    Verifică faptul că cel puțin două produse conțin numele categoriei selectate.

    @Test
    public void exercitiul1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement categoryDropdown = driver.findElement(By.xpath("//*[contains(text(), 'Categories')]"));
        categoryDropdown.click();

        driver.findElement(By.xpath("//*[@data-test='nav-hand-tools']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Hand Saw')]/input"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("card-title"), "Saw"));

        List<WebElement> products = driver.findElements(By.xpath("//*[@data-test='product-name']"));
        Assert.assertTrue(products.size() >= 2, "Nu exista cel putin 2 produse.");
    }

//    Folosind pagina https://practicesoftwaretesting.com/
//    Deschide un produs.
//    Apasă Add to cart.
//    Deschide coșul.
//    Verificare:
//    produsul apare în coș
//    cantitatea este 1.

    @Test
    public void exercitiul2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@data-test='product-name'])[9]")));

        WebElement thorHammer = driver.findElement(By.xpath("(//*[@data-test='product-name'])[9]"));
        String cartThorHammer = thorHammer.getText();
        thorHammer.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-add-to-cart"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test='cart-quantity']"))).click();

        System.out.println(cartThorHammer);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("product-title"), cartThorHammer));

        WebElement cartProduct = driver.findElement(By.className("product-title"));
        WebElement cartQuantity = driver.findElement(By.xpath("//input[@data-test='product-quantity']"));

        Assert.assertEquals(cartThorHammer, "Thor Hammer", "Produsul nu exista in cos.");
        Assert.assertTrue(cartQuantity.equals(cartQuantity), "Cantitatea nu este egala.");
    }

//    Accesează site-ul.
//    Caută produsul Hammer.
//    Deschide produsul.
//    Adaugă produsul în coș.
//    Deschide coșul.
//    Verifică:
//    produsul este în coș
//    cantitatea este 1
//    prețul este afișat.

    @Test
    public void exercitiul3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("search-query")));
        WebElement search = driver.findElement(By.id("search-query"));
        search.sendKeys("Hammer");
        search.submit();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@data-test='product-name'])[2]")));
        WebElement hammer = driver.findElement(By.xpath("(//*[@data-test='product-name'])[2]"));
        String hammerText = hammer.getText();
        hammer.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-add-to-cart"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test='cart-quantity']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-title")));

        WebElement cartProduct = driver.findElement(By.className("product-title"));

        System.out.println(hammerText);

        Assert.assertEquals(hammerText, "Hammer", "Produsul nu exista in cos.");

        WebElement cartQuantity = driver.findElement(By.xpath("//input[@data-test='product-quantity']"));
        Assert.assertTrue(cartQuantity.equals(cartQuantity), "Cantitatea nu este egala.");

        WebElement cartPrice = driver.findElement(By.xpath("//*[@data-test='product-price']"));

        Assert.assertTrue(cartPrice.isDisplayed(), "Pretul nu este afisat.");
    }
}
