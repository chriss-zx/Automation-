package Teme.Tema9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver){
        super(driver);
    }

    public void openApp() {
        driver.get("https://practicesoftwaretesting.com/");
    }

    public void clickOnProduct(String productName) {
        String xpath = "//h5[contains(text(), '" + productName + "')]";
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }
}
