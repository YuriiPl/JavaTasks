package com.home.urix.lesson7;

public class Main {

    public static void main(String[] args) {
        Shape shape = new Rectangle(new Point(3,4),new Point(7,6));
        System.out.println(shape);

        shape = new Circle(new Point(3,4),7.4);
        System.out.println(shape);

        shape = new Triangle(new Point(3,4),new Point(7,-6),new Point(-7,6));
        System.out.println(shape);
    }
}
