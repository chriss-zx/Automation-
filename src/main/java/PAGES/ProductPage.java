package PAGES;

import org.openqa.selenium.*;

public class ProductPage {

    private WebDriver driver;

    private By name = By.className("inventory_details_name");
    private By price = By.className("inventory_details_price");
    private By addToCartBtn = By.id("add-to-cart");
    private By cartButton = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(name).getText();
    }

    public String getProductPrice() {
        return driver.findElement(price).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

}