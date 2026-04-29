package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class herokuappTests {

    WebDriver driver;

    @Test
    public void checkboxesTest() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.selectCheckbox1();
        checkboxesPage.selectCheckbox2();
    }


    @Test
    public void dropdownTest() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.selectOptionFromDropdown("Option 1");
        dropdownPage.selectOptionFromDropdown("Option 2");
    }

    @Test
    public void radioButtonTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickYes();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        radioButtonPage.clickImpressive();
    }
}
