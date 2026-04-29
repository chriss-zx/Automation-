package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExercitiuTest {

    WebDriver driver;

    @Test
    public void loginTestValid() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("student", "Password123");
        Assert.assertTrue(loginPage.isValidMsgPresent(), "Login invalid.");
    }

    @Test
    public void loginTestInvalid() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("incorrectUser", "Password123");
        Assert.assertTrue(loginPage.isInvalidMsgPresent(), "Login invalid.");
    }
}