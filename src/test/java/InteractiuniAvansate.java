import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InteractiuniAvansate {

    WebDriver driver;

    // select

    @Test
    public void testDropdownSelect() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        // selecteaza culoarea blue
        WebElement selectDropdownLocator = driver.findElement(By.id("oldSelectMenu"));
        Select dropdown = new Select(selectDropdownLocator);

        dropdown.selectByVisibleText("Blue");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // selecteaza culoarea yellow folosind value
        dropdown.selectByValue("3");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // selecteaza culoarea purple folosind index
        dropdown.selectByIndex(4);

        String selectedOptionText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionText, "Purple");
    }

    @Test
    public void dropdownNew() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        WebElement dropdown = driver.findElement(By.className("css-13cymwt-control"));
        dropdown.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        WebElement option1 = driver.findElement(By.xpath("//div[text()='Group 1, option 1']"));
//        option1.click();

        WebElement option1 = driver.findElement(By.id("react-select-2-option-0-0"));
        option1.click();

//        dropdown.sendKeys("Group 1, option 1");


    }


    // checkbox

    @Test
    public void checkboxTest() {
        driver = new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), 'MightyCraft Hardware')]/input"));
        checkbox.click();
        checkbox.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, false));

        // verificare
        boolean isCheckboxSelected = checkbox.isSelected();

        if (isCheckboxSelected == true) {
            System.out.println("este selectat.");
        } else {
            System.out.println("nu este selectat.");
            checkbox.click();
        }

        isCheckboxSelected = checkbox.isSelected();

        Assert.assertTrue(isCheckboxSelected);
    }



    // radio button

    @Test
    public void testRadioButton() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.id("yesRadio"));
        WebElement impressiveButton = driver.findElement(By.id("impressiveRadio"));

        yesButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        impressiveButton.click();
    }


    // upload
    @Test
    public void upload() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");

        driver.findElement(By.id("uploadFile")).sendKeys("D:\\Curs testare automata\\test upload.txt");
    }

    // actions
    @Test
    public void testActions() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        Actions actiuni = new Actions(driver);
        actiuni.doubleClick(doubleClickBtn).perform();

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actiuni.contextClick(rightClickBtn).perform();

        WebElement clickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickBtn.click();
    }
}