package part4.task4_2;

public class Square extends Rectangle {

    public Square(String color, double side) {
        super(color, side, side);
        if (side <= 0) throw new IllegalArgumentException("Сторона должна быть > 0");
    }

    @Override
    public void draw() {
        System.out.printf("Рисую %s квадрат %.1f x %.1f%n", color, width, height);
    }
}
