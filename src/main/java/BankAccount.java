public class BankAccount {

    private String owner;
    private double balance;
    private String iban;


    public BankAccount(String owner, double balance, String iban) {
        this.owner = owner;
        this.balance = balance;
        this.iban = iban;
    }

    public void ownerNotNull() {
        if(owner.isEmpty()) {
            System.out.println("This account dosen't have an owner.");
        } else {
            System.out.println("Welcome, " + this.owner);
        }
    }

    public void deposit(double amount) {
        if(amount<0) {
            System.out.println("Operatiune nepermisa.");
        } else {
            this.balance = this.balance + amount;
        }
    }

    public void withdraw(double amount) {
        if (this.balance <= 0) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance = this.balance - amount;
        }
    }

    public void displayBalance() {
        System.out.println("Your balance is: " + balance);
    }

    public static void main(String []args) {
        BankAccount ac1 = new BankAccount("Mircea", 2, "IBN000000RON2736423");

        ac1.displayBalance();

        ac1.deposit(-2);
        ac1.displayBalance();

        ac1.ownerNotNull();

        ac1.withdraw(2);
        ac1.displayBalance();

        ac1.deposit(8733);
        ac1.displayBalance();

    }

}
