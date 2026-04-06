package Teme.Tema7;

public class BankAccount {
//
//    2. Creează clasa BankAccount:

//    Atribute:
//    ownerName
//    balance

//    Metode:
//    deposit(double amount)
//    withdraw(double amount)
//    displayBalance()

//    Reguli:
//    nu permite retragere dacă balance < amount

//    În main:
//    creează un cont
//    fă 2 depuneri și 1 retragere

    String ownerName;
    double balance;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
                this.balance = this.balance - amount;
        }
    }

    public void displayBalance() {
        System.out.println("Your balance is: " + balance);
    }

    public static void main(String []args) {
        BankAccount cristi = new BankAccount("Cristi", 0);

        cristi.deposit(2000);
        cristi.displayBalance();

        cristi.withdraw(1000);
        cristi.displayBalance();

        cristi.deposit(847.63);
        cristi.displayBalance();

    }
}
