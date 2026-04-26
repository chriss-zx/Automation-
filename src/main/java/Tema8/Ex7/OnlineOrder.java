package Tema8.Ex7;

public class OnlineOrder extends Order {
    protected int orderId;

    public void trackOrder(int orderId) {
        System.out.println("Order number " + orderId + " is currently in deposit.");
    }
}
