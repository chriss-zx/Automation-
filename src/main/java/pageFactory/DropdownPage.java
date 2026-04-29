package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    WebDriver driver;

    private @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectOptionFromDropdown(String option) {
        Select dropdown = new Select(this.dropdown);
        dropdown.selectByVisibleText(option);
    }

}
