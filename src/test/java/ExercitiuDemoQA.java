import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExercitiuDemoQA {

    @Test
    public void textBox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        String fullNameValue = "Cristi";

        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAdress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.className("btn-primary"));
        boolean submitDisplay = submit.isDisplayed();
        boolean submitEnabled = submit.isEnabled();

        Assert.assertTrue(submitDisplay, "Button is not displayed.");
        Assert.assertTrue(submitEnabled, "Button is not enabled.");


        fullName.sendKeys(fullNameValue);
        email.sendKeys("cristi@test.com");
        currentAdress.sendKeys("Timisoara");
        permanentAdress.sendKeys("Timisoara");

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView(true);", submit);


        submit.click();


        WebElement output = driver.findElement(By.id("output"));

        // Assert.assertTrue(output.isDisplayed());

        String outputName = driver.findElement(By.id("name")).getText();

        System.out.println(outputName);

        Assert.assertTrue(outputName.contains(fullNameValue));
    }


    @Test
    public void textBoxNegativ() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAdress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.className("btn-primary"));


        fullName.sendKeys("Cristi");
        email.sendKeys("cristi");
        currentAdress.sendKeys("Timisoara");
        permanentAdress.sendKeys("Timisoara");

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView(true);", submit);


        submit.click();

        String classAttribute = email.getAttribute("class");
        System.out.println(classAttribute);

        Assert.assertTrue(classAttribute.contains("field-error"));
    }


    @Test
    public void buttons() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        Actions click = new Actions(driver);
        click.doubleClick(doubleClickBtn).perform();

        WebElement outputMsgDoubleClick = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(outputMsgDoubleClick.isDisplayed());


        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        click.contextClick(rightClickBtn).perform();

        WebElement outputMsgRightClick = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(outputMsgRightClick.isDisplayed());


        WebElement clickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickBtn.click();

        WebElement outputMsgClick = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(outputMsgClick.isDisplayed());
    }

    @Test
    public void check() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        WebElement checkbox = driver.findElement(By.xpath("//span[@role='checkbox']"));
        checkbox.click();

        WebElement text = driver.findElement(By.xpath("//span[contains(text(), 'Ho')]"));
        text.getText();

        String textHome = text.getText();

        Assert.assertEquals(textHome, "Home", "Mesajul nu este corect.");

    }


    @Test
    public void buton() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMe.click();

        WebElement output = driver.findElement(By.id("dynamicClickMessage"));

        boolean outputMsg = output.isDisplayed();

        Assert.assertTrue(outputMsg, "Message is not displayed");

        String dynamicClickMsg = output.getText();
        Assert.assertEquals(dynamicClickMsg, "You have done a dynamic click", "Message is not correct.");

    }


    @Test
    public void clearText() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Cristi");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("cristi@test.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fullName.clear();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fullName.sendKeys("Test");
    }
}