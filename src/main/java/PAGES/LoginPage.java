package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.id("user-name");
    By password = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//input[@data-test='login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage loginAs(String username, String password) {
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginBtn).click();

        return new HomePage(driver);
    }
}
