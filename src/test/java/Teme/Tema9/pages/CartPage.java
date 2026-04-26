package Teme.Tema9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public By cart = By.xpath("//a[@data-test='nav-cart']");
    public By cartQuantity = By.xpath("//span[@data-test='cart-quantity']");
    public By itemName = By.xpath("//h5[@data-test='product-name']");
    public By cartProduct = By.className("product-title");

    public void goToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartQuantity)).click();
    }

    public String isProductInCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartProduct));
        return driver.findElement(cartProduct).getText();
    }
}
