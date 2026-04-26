package Tema8.Ex2;
//
//Creează clasa Product:
//        - private name, price
//- în setter pentru price: nu permite valori <= 0
//        - testează valori valide și invalide

public class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if(price <= 0) {
            System.out.println("Pretul nu poate fi mai mic decat 0.");
        } else {
            this.price = price;
        }
    }
}
