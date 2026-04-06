package Teme.Tema7;

public class ShoppingCart {

//    5. Creează clasa ShoppingCart:

//    Atribute:
//    totalPrice

//    Metode:
//    addProduct(double price)
//    removeProduct(double price)
//    getTotal()

//    Reguli:
//    totalPrice nu poate deveni negativ

//    În main:
//    adaugă 3 produse
//    șterge unul
//    afișează totalul

    double totalPrice;

    public ShoppingCart(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double addProduct(double price) {
        return this.totalPrice = this.totalPrice + price;
    }

    public void removeProduct(double price) {
        if (totalPrice - price < 0) {
            System.out.println("Your total can't be below 0.");
        } else {
            this.totalPrice = this.totalPrice - price;
        }
    }

    public void getTotal() {
        System.out.println("Your total is: " + totalPrice);
    }


    public static void main(String []args) {
        ShoppingCart p1 = new ShoppingCart(26.39);
        ShoppingCart p2 = new ShoppingCart(999.99);
        ShoppingCart p3 = new ShoppingCart(59.76);
        p1.removeProduct(40);
        p1.getTotal();

        p2.addProduct(443);
        p3.addProduct(22);
        p2.getTotal();
        p3.getTotal();
    }
}
