package Tema8.Ex6;

public class EmailNotification {
    private String emailAdress;

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public void send() {
        System.out.println("Email notification sent.");
    }
}
