package ExercitiuBreakRoom;

public class Transport {
    protected int speed;

    public Transport(int speed) {
        this.speed = speed;
    }

    public void move() {
        System.out.println("Transport merge cu viteza de: " + speed + " km/h.");
    }
}
