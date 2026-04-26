package Teme.Tema9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

public String getProductInfo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(description)).getText();
    }

   public By name = By.xpath("//h1[@data-test='product-name']");
   public By price = By.xpath("//*[@data-test='unit-price']");
   public By description = By.id("description");
   public By addToCartBtn = By.id("btn-add-to-cart");

   public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(name)).getText();
    }

   public String getPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(price)).getText();
    }

    public void addToCart() {
       driver.findElement(addToCartBtn).click();
    }
}
