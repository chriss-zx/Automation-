package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By menuButton = By.xpath("//button[text()='Open Menu']");
    By cartButton = By.xpath("//a[@data-test='shopping-cart-link']");
    By logoutButton = By.xpath("//a[@data-test='logout-sidebar-link']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        driver.findElement(this.menuButton).click();
        driver.findElement(this.logoutButton).click();
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}
