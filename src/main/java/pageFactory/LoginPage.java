package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindBy(id = "error")
    WebElement errorMsg;

    @FindBy(xpath = "//h1[@class='post-title']")
    WebElement loginSuccesful;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void loginAs(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        submitBtn.click();
    }

    public boolean isInvalidMsgPresent() {
       return errorMsg.isDisplayed();
    }

    public boolean isValidMsgPresent() {
        return loginSuccesful.isDisplayed();
    }
}
