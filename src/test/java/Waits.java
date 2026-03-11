import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {

    WebDriver driver = new FirefoxDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test
    public void testElementClickable() {
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));

        button.click();
    }

    @Test
    public void testElementVisible() {
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement buttonVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        boolean isDisplayed = buttonVisible.isDisplayed();

        Assert.assertTrue(isDisplayed, "Button is not visible after 5 seconds.");
    }

    @Test
    public void testTextElementIsPresent() {
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();


        boolean textOnButtonPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("visibleAfter"), "Visible After 5 Seconds"));

        Assert.assertTrue(textOnButtonPresent, "Textul nu este prezent.");
    }
}
