import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExercitiuWait {

  // - Creează o metodă reutilizabilă ‘waitForElementVisible(By locator)’ care returnează elementul.
    //- Aplică această metodă pentru un test în https://demoqa.com/dynamic-properties
    //- Creează alte metode utile pentru teste din aceeași pagină


    WebDriver driver = new FirefoxDriver();

    public WebElement waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return buttonVisible;
    }

    @Test
    public void testElementVisible() {
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement buttonVisible = waitForElementVisible(By.id("visibleAfter"));

        boolean isDisplayed = buttonVisible.isDisplayed();

        Assert.assertTrue(isDisplayed, "Button is not visible after 5 seconds.");
    }


}
