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

        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAdress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.className("btn-primary"));


        fullName.sendKeys("Cristi");
        email.sendKeys("cristi@test.com");
        currentAdress.sendKeys("Timisoara");
        permanentAdress.sendKeys("Timisoara");

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView(true);", submit);


        submit.click();



        WebElement output = driver.findElement(By.id("output"));

        Assert.assertTrue(output.isDisplayed());
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








}





//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class ActionsButtons {
//
//    @Test
//    public void test1(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demoqa.com/checkbox");
//
//        WebElement doubleClickMeButton = driver.findElement(By.className("rc-tree-checkbox"));
//
//        doubleClickMeButton.click();
//    }
//
//    @Test
//    public void test(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demoqa.com/buttons");
//
//        WebElement doubleClickMeButton = driver.findElement(By.id("doubleClickBtn"));
//        WebElement rightClickMeButton = driver.findElement(By.id("rightClickBtn"));
//
//
//        Actions actions = new Actions(driver);
//        actions.doubleClick(doubleClickMeButton).perform();
//
//        WebElement outputMessageDoubleClick = driver.findElement(By.id("doubleClickMessage"));
//        Assert.assertTrue(outputMessageDoubleClick.isDisplayed());
//
//
//        actions.contextClick(rightClickMeButton).perform();
//
//        WebElement outputMessageRightClick = driver.findElement(By.id("rightClickMessage"));
//        Assert.assertTrue(outputMessageRightClick.isDisplayed());
//
//        WebElement clickMeButton = driver.findElement(By.xpath("//*[text()='Click Me']"));
//        clickMeButton.click();
//
//        WebElement outputMessageClick = driver.findElement(By.id("dynamicClickMessage"));
//        Assert.assertTrue(outputMessageClick.isDisplayed());
//    }
//}