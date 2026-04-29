package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {

    WebDriver driver;

    private @FindBy(id = "yesRadio")
    WebElement yesButton;

    private @FindBy(id = "impressiveRadio")
    WebElement impressiveButton;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickYes() {
        yesButton.click();
    }

    public void clickImpressive() {
        impressiveButton.click();
    }
}
