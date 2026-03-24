import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExercitiuNavigate {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void exercitiul1() {
        driver.get("https://demoqa.com/");

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://demoqa.com/elements");

        String pageURL = driver.getCurrentUrl();
        System.out.println(pageURL);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void exercitiul2() {
        driver.get("https://demoqa.com/");

        String originalTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/forms");

        driver.switchTo().window(originalTab);
    }


    @Test
    public void exercitiul3() {
        driver.get("https://demoqa.com/");
        driver.navigate().to("https://demoqa.com/elements");

        String elementsTitle = driver.getTitle();

        driver.navigate().to("https://demoqa.com/forms");

        driver.navigate().back();
        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("elements"), "Nu suntem pe pagina Elements.");

        driver.navigate().forward();
        currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("forms"), "Nu suntem pe pagina Forms.");

        driver.navigate().refresh();
    }


//    Deschide https://demoqa.com/
//    Navighează la: Alerts
//    Navighează la: Widgets
//    Mergi back de 2 ori

    @Test
    public void exercitiul4() {
        driver.get("https://demoqa.com/");
        String pageTitle = driver.getTitle();
        driver.navigate().to("https://demoqa.com/alerts");
        driver.navigate().to("https://demoqa.com/widgets");
        driver.navigate().back();
        driver.navigate().back();

        String currentPageTitle = driver.getTitle();

        Assert.assertTrue(pageTitle.equals(currentPageTitle));
    }

//    1. Deschide https://demoqa.com/
//            2. Deschide 3 tab-uri
//3. Navighează în fiecare la o secțiune diferită
//    a. Elements
//    b. Forms
//    c. Alerts
//4. Printează titlul fiecărei pagini

    @Test
    public void exercitiul5() {
        driver.get("https://demoqa.com/");
        String mainPageTitle = driver.getTitle();
        System.out.println(mainPageTitle);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/elements");

        String elementsPageTitle = driver.getTitle();
        System.out.println(elementsPageTitle);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/forms");

        String formsPageTitle = driver.getTitle();
        System.out.println(formsPageTitle);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/alerts");

        String alertsPageTitle = driver.getTitle();
        System.out.println(alertsPageTitle);

        driver.close();
        driver.quit();
    }
}
