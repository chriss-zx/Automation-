package Teme.Tema9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public By search = By.id("search-query");

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void insertText(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        element.sendKeys(text);
        element.submit();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

}
