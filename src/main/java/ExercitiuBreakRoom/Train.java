package ExercitiuBreakRoom;

public class Train extends Transport {
    public Train(int speed) {
        super(speed);
    }

    public void move() {
        System.out.println("Trenul merge cu viteza de: " + speed + " km/h.");
    }

    public void openDoors() {
        System.out.println("Train doors are opening.");
    }
}