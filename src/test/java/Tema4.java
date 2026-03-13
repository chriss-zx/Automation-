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

import java.time.Duration;

public class Tema4 {

    WebDriver driver;
    WebDriverWait wait;

    public WebElement waitForElementVisible(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement visible = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return visible;
    }


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


//    1. Creează un test care:
    @Test
    public void openPage() {
//    Deschide aplicația https://practicesoftwaretesting.com/ .
        driver.get("https://practicesoftwaretesting.com/");

//    Verifică titlul paginii.
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Practice Software Testing - Toolshop"));

        waitForElementVisible(By.xpath("(//*[@data-test='product-name'])[1]"));

//    Verifică dacă logo-ul aplicației este vizibil.
        boolean logo = driver.findElement(By.id("Layer_1")).isDisplayed();
        Assert.assertTrue(logo, "Logo-ul nu este vizibil.");
    }


//    2. Creează un test pentru căutarea unui produs
    @Test
    public void searchProduct() {
        driver.get("https://practicesoftwaretesting.com/");

//    Identifică search bar.
        WebElement search = waitForElementVisible(By.xpath("//input[@placeholder='Search']"));

//    Introdu textu “hammer”
        search.sendKeys("hammer");

//    Apasă Enter sau butonul de căutare.
        search.submit();

//    Așteaptă afișarea rezultatelor.
        WebElement itemSearch = waitForElementVisible(By.xpath("(//*[@data-test='product-name'])[1]"));

//    Verifică dacă apare cel puțin un produs în listă.
        Assert.assertTrue(itemSearch.isDisplayed(), "Nu a fost gasit niciun produs.");
    }

//    3. Creează un test pentru deschiderea unui produs

    @Test
    public void openProduct() {
//    Deschide pagina principală.
        driver.get("https://practicesoftwaretesting.com/");

//    Așteaptă încărcarea produselor.
//    Apasă pe primul produs din listă.

        waitForElementVisible(By.xpath("(//*[@data-test='product-name'])[1]")).click();

//    Verifică dacă:
//    imaginea produsului este vizibilă
        WebElement image = waitForElementVisible(By.xpath("//img[contains(@class, 'img-fluid')]"));
        Assert.assertTrue(image.isDisplayed(), "Imaginea nu este vizibila.");

//    butonul Add to cart este vizibil.
        WebElement button = driver.findElement(By.id("btn-add-to-cart"));
        Assert.assertTrue(button.isDisplayed(), "Butonul nu este vizibil.");
    }


//    4. Creează un test pentru filtrarea produselor
    @Test
    public void filters() {
//    Deschide pagina principală.
        driver.get("https://practicesoftwaretesting.com/");

        waitForElementVisible(By.xpath("(//*[@data-test='product-name'])[1]"));

//    Selectează un filtru (ex: brand sau categorie)
        driver.findElement(By.xpath("//*[@data-test='category-01KKM946K85EBD1Q6MT4GMXTPN']")).click();

//    Așteaptă actualizarea listei.
        waitForElementVisible(By.xpath("//*[@data-test='filter_completed']"));

//    Verifică dacă produsele afișate respectă filtrul.


    }

}