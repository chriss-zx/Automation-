package Polimorph;

public class MainPayment {
    public static void main(String []args) {
        Payment pay1 = new CreditCardPayment();
        Payment pay2 = new PayPalPayment();

        pay1.pay();
        pay2.pay();

        System.out.println();

        pay1 = new PayPalPayment();
        pay2 = new CreditCardPayment();

        pay1.pay();
        pay2.pay();
    }
}
