package Interfete;

public class MainInterface {
    public static void main(String []args) {
        LoginPage loginPage = new LoginPage();

        loginPage.enterUsername("cristi");
        loginPage.enterPassword("test123");
        loginPage.clickLogin();
    }
}
