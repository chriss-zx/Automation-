package Tema8.Ex4;

public class Account {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void login() {
        System.out.println("Welcome, " + getUsername() + "!");
    }
}
