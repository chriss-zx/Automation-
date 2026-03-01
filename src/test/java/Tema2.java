import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tema2 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // 1. Deschide un site -> deschide browser, navigheaza catre un URL (la alegere), inchide browserul

    @Test
    public void openYT() {
        driver.get("https://www.youtube.com");

        // 2. Verifica titlul paginii -> deschide URL-ul (la alegere, sau https://example.com/), ia titlul paginii, verifica cu Assert titlul

        String actualTitle = driver.getTitle();
        System.out.println("Titlul paginii este: " + driver.getTitle());
        Assert.assertTrue(actualTitle.contains("YouTube"), "Titlul nu contine YouTube.");

    }


    // 3. Creaza o clasa care are doua teste: unul care navigheaza la https://example.com/ si inchide browserul; unul care navigheaza la https://www.apple.com/ si inchide browserul.


    @Test
    public void pages() {
        driver.get("https://example.com");

        driver.navigate().back();

        driver.get("https://www.apple.com");
    }

    // 5. Creaza un test prin care se navigheaza la https://example.com si verifica:
    //Titlul nu este null
    //Titlul contine ‘Example’

    @Test
    public void openExample() {
        driver.get("https://example.com");

        String actualTitle = driver.getTitle();
        Assert.assertNotNull(actualTitle);
        System.out.println("Titlul paginii este: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("Example"), "Titlul nu contine 'Example'.");
    }


}
