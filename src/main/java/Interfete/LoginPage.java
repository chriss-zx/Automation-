package Interfete;

public class LoginPage implements LoginActions {

    @Override
    public void enterUsername(String username) {
        System.out.println(username);
    }

    @Override
    public void enterPassword(String password) {
        System.out.println(password);
    }

    @Override
    public void clickLogin() {
        System.out.println("Login button clicked.");
    }
}
