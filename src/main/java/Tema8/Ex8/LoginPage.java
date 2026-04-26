package Tema8.Ex8;

public class LoginPage extends BasePage {

    public LoginPage(String pageTitle) {
        super(pageTitle);
    }

    public void login(String username, String password) {
        System.out.println("Login successful.");
    }
}
