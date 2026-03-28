package Teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tema6 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

//   1. Creează un test care:
//    deschide un site
//    deschide un tab nou (WindowType.TAB)
//    accesează alt site în noul tab
//    Afișează titlul ambelor taburi

    @Test(groups = {"test"}, priority = 2)
    public void exercitiul1() {
        driver.get("https://demoqa.com/");

        String firstTab = driver.getTitle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://practicesoftwaretesting.com/");

        String secondTab = driver.getTitle();
        System.out.println(firstTab);
        System.out.println(secondTab);
    }

//    2. Creează un test care:
//    deschide 2 taburi
//    salvează windowHandles
//    navighează între ele
//    Verifică titlul fiecărui tab folosind Assert

    @Test(groups = {"test"}, priority = 1)
    public void exercitiul2() {
        driver.get("https://github.com/");

        String firstTab = driver.getWindowHandle();
        String firstTabTitle = driver.getTitle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.w3schools.com/");

        String secondTab = driver.getWindowHandle();
        String secondTabTitle = driver.getTitle();

        driver.switchTo().window(firstTab);
        driver.switchTo().window(secondTab);

        System.out.println(firstTabTitle);
        System.out.println(secondTabTitle);

        Assert.assertTrue(firstTabTitle.contains("GitHub"), "Titlul nu corespunde. - GitHub");
        Assert.assertTrue(secondTabTitle.contains("W3Schools"), "Titlul nu corespunde. - W3Schools");
    }

//  3. Creează un test care:
//    deschide 2 taburi
//    închide unul cu driver.close()
//    revine pe tabul principal
//    Verifică dacă încă ești pe pagina corectă
//    Ruleaza testul folosing fisier .xml

    @Test(groups = {"smoke"}, priority = 3)
    public void exercitiul3() {
        driver.get("https://github.com/");

        String originalTab = driver.getWindowHandle();
        String originalTabTitle = driver.getTitle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.w3schools.com/");

        driver.close();

        driver.switchTo().window(originalTab);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.wikipedia.org/");

        String secondTab = driver.getWindowHandle();
        String secondTabTitle = driver.getTitle();

        System.out.println(originalTabTitle);
        System.out.println(secondTabTitle);

        boolean foundSite = false;

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);

            if (driver.getTitle().contains("W3Schools")) {
                foundSite = true;
                break;
            }
        }
        if (!foundSite) {
            driver.switchTo().newWindow(WindowType.TAB);
            driver.navigate().to("https://www.w3schools.com/");
        }
    }

//   4. Creează un test care:
//    Deschide https://practicesoftwaretesting.com/
//    Navighează pe o categorie
//    Deschide produsul într-un tab nou
//    Revine în tabul principal
//    Face refresh
//    Adauga:
//    @BeforeMethod
//    @AfterMethod
//    Assert
//    Ruleaza testul folosind un fisier .xml

    @Test(groups = {"smoke"}, priority = -1)
    public void exercitiul4() {
        driver.get("https://practicesoftwaretesting.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-test='product-name'])[1]")));

        driver.findElement(By.xpath("//label[contains(text(), 'Wrench')]")).click();

        String currentTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-test='product-name'])[1]")));

        driver.findElement(By.xpath("//label[contains(text(), 'Wrench')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Adjustable Wrench')]")));

        driver.findElement(By.xpath("(//h5[@data-test='product-name'])[1]")).click();

        driver.switchTo().window(currentTab);
        driver.navigate().refresh();
    }

//          5. Creaza cateva teste simple (la alegere, cu body complet si Assert), seteaza prioritati incepand de la -1
//          6. Creaza cateva teste simple (la alegere, cu body complet si Assert), seteaza groups si ruleaza-le dintr-un fisier .xml

    @Test(groups = {"smoke"} ,priority = -1)
    public void testDemoQA() {
        driver.get("https://demoqa.com/select-menu");

        WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldSelectMenu);
        select.selectByValue("1");

        String selectedOptionText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionText, "Blue", "Optiunea selectata nu este corecta.");

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        Actions actiuni = new Actions(driver);

        actiuni.doubleClick(doubleClickBtn).perform();

        WebElement doubleClickMsg = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleClickMsg.isDisplayed(), "Mesajul nu este vizibil.");
    }

    @Test(groups = {"smoke"} ,priority = 1)
    public void priority1() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement categoryDropdown = driver.findElement(By.xpath("//*[contains(text(), 'Categories')]"));
        categoryDropdown.click();

        driver.findElement(By.xpath("//*[@data-test='nav-hand-tools']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Hand Saw')]/input"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("card-title"), "Saw"));

        List<WebElement> products = driver.findElements(By.xpath("//*[@data-test='product-name']"));
        Assert.assertTrue(products.size() >= 2, "Nu exista cel putin 2 produse.");
    }
}