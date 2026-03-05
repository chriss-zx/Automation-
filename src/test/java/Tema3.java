import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tema3 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void formular() {

        driver.get("https://demoqa.com/automation-practice-form");

        // 1. Gaseste campul First Name folosind Xpath, bazat pe placeholder
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder= 'First Name']"));

        // 2. Introdu in acel camp valoarea “Test”
        firstName.sendKeys("Test");

        // 3. Gaseste campul Last Name folosing XPath bazat pe atributul id

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));

        // 4. Introdu valoarea “User”
        lastName.sendKeys("User");

        // 5. Gaseste campul Email folosing XPath bazat pe atributul id
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));

        // 6. Introdu textul “test@email.com”
        email.sendKeys("test@email.com");

        // 7. Apasa oricare din butoanele radio de la Gender
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        gender.click();

        // 8. Introdu un numar de telefon in campul pentru Mobile
        WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        mobile.sendKeys("0712341234");

        // 9. Introdu un text in campul pentru ‘Subjects’
        WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subject.sendKeys("ITSchool");

        // 10. Introdu un text in campul pentru ‘Current Address’
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("Timisoara");

        // 11. Gaseste butonul Submit dupa text si apasa folosind click
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        // 12. BONUS optional: verifica aparitia pop-up-ului de confirmare si apasa pe butonul Close
        WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));
        closeButton.click();
    }


    @Test
    public void webTables() {
        driver.get("https://demoqa.com/webtables");

        // 1. Da click pe butonul ‘Add’
        WebElement addButton = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        addButton.click();


        // 2. Completeaza toate campurile din pop-up-ul care se deschide
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys("Cristi");

        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Nacea");

        WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder, '@')]"));
        email.sendKeys("cristi@test.com");

        WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
        age.sendKeys("24");

        WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
        salary.sendKeys("777");

        WebElement department = driver.findElement(By.xpath("//input[@id='department']"));
        department.sendKeys("test");


        // 3. Da click pe butonul Submit
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();
    }


    @Test
    public void radio() {

        driver.get("https://demoqa.com/radio-button");

        WebElement yesCheckBox = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        yesCheckBox.click();

        WebElement yesMsg = driver.findElement(By.xpath("//p[@class='mt-3']"));
        yesMsg.getText();

        String outputMsg = yesMsg.getText();
        Assert.assertEquals(outputMsg, "You have selected Yes");
    }

}
