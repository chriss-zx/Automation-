package Abstractizare;

public class MainAbstract {
    public static void main(String []args) {
        Circle circle = new Circle();
        int areaCircle = circle.calculateArea(13, 0);
        System.out.println("Aria cerc: " + areaCircle);

        Rectangle rectangle = new Rectangle();
        int areaRectangle = rectangle.calculateArea(4, 5);
        System.out.println("Aria dreptunghi: " + areaRectangle);

       String drawCircle = circle.draw();
        System.out.println(drawCircle);
    }
}
