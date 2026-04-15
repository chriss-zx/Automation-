package ExercitiuBreakRoom;

public class Car extends Transport {
    public Car(int speed) {
        super(speed);
    }

    public void move() {
        System.out.println("Masina merge cu viteza de: " + speed + " km/h.");
    }

    public void honk() {
        System.out.println("Masina claxoneaza.");
    }
}
