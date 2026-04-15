package ExercitiuBreakRoom;

public class Plane extends Transport {
    public Plane(int speed) {
        super(speed);
    }

    public void move() {
        System.out.println("Avionul zboara cu viteza de: " + speed + " km/h.");
    }

    public void takeOff() {
        System.out.println("Avionul decoleaza!");
    }
}
