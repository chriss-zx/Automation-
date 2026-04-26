package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    private By itemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> items = driver.findElements(itemName);

        for (int i = 0; i < items.size(); i++) {
            String text = items.get(i).getText();

            if (text.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
}