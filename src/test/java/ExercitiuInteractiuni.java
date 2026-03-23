import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExercitiuInteractiuni {



//    Scenariu
//1. Navighează la
//    https://demoqa.com/select-menu
//            2. Selectează Blue
//3. Verifică valoarea selectată
//4. Navighează la
//    https://demoqa.com/buttons
//            4. Execută:
//    a. double click
//    b. right click
//5. Verifică mesajele.

    WebDriver driver;

    @Test
    public void testDemoQA() {
        driver = new ChromeDriver();
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




//    Folosind pagina https://practicesoftwaretesting.com/
//    a. Navighează la lista de produse.
//    b. Identifică dropdown-ul Sort.
//    c. Selectează opțiunea Price (High → Low).
//    d. Verifică că primul produs are prețul mai mare decât produsul următor.

    @Test
    public void testPracticeSW() {
        driver = new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/");

        WebElement dropdownSortMenu = driver.findElement(By.xpath("//*[@data-test='sort']"));

        Select select = new Select(dropdownSortMenu);
        select.selectByVisibleText("Price (High - Low)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//*[@data-test='product-name'])[1]"), "Drawer Tool Cabinet" ));


        WebElement firstProductPrice = driver.findElement(By.xpath("(//*[@data-test='product-price'])[1]"));
        WebElement secondProductPrice = driver.findElement(By.xpath("(//*[@data-test='product-price'])[2]"));

        String firstProductPriceText = firstProductPrice.getText();
        String secondProductPriceText = secondProductPrice.getText();

        System.out.println(firstProductPriceText + " " + secondProductPriceText);

        firstProductPriceText = firstProductPriceText.replace("$", "");
        secondProductPriceText = secondProductPriceText.replace("$", "");

        System.out.println(firstProductPriceText + " " + secondProductPriceText);

        double firstPrice = Double.parseDouble(firstProductPriceText);
        double secondPrice = Double.parseDouble(secondProductPriceText);

        System.out.println(firstPrice + " " + secondPrice);

        Assert.assertTrue(firstPrice > secondPrice, "Primul pret nu este mai mare.");
    }
}
