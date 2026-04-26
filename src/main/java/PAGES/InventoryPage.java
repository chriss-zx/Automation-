package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    WebDriver driver;

    By products = By.className("inventory_item");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getProductsCount() {
        return driver.findElements(products).size();
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(products);
    }

    public void addProductToCart(String productName) {
        String xpath = "//div[text()='" + productName +"']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickOnProduct(String productName) {
        String xpath = "//div[text()='" + productName + "']";
        driver.findElement(By.xpath(xpath)).click();
    }
}
