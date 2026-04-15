package ExercitiuBreakRoom;

public class MainTransport {

    public static void main(String []args) {
        Car car = new Car(130);
        Train train = new Train(40);
        Plane plane = new Plane(900);

        car.move();
        train.move();
        plane.move();
        car.honk();
        train.openDoors();
        plane.takeOff();
    }
}
