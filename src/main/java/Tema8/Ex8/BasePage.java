package Tema8.Ex8;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    public String pageTitle;

    public BasePage(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public void openUrl() {
        System.out.println("Opens URL: https://www.google.com");
    }
}
