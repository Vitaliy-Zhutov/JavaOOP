package homework6;

import homework6.Work3.Greeter;
import homework6.Work3.GreetingCasual;
import homework6.work1.Rectangle;
import homework6.work1.Square;

public class Main {
    public static void main(String[] args) {
        // I.work1
        Square square = new Square();
        square.setSide(8);
        System.out.println("Сторона квадрата: " + square.getSide());

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(11);
        rectangle.setWidth(7);
        System.out.println("Стороны прямоугольника: " + rectangle.getHeight() + " и " + rectangle.getWidth());

        // III.work3
        Greeter greeter = new Greeter();
        System.out.println(greeter.greet());
        greeter.setGreeting(new GreetingCasual());
        System.out.println(greeter.greet());
    }
}
