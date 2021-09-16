package com.home.urix.lesson7;

public class Triangle extends Shape {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        testData(firstPoint,secondPoint,thirdPoint);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    public static void testData(Point firstPoint, Point secondPoint, Point thirdPoint) {
        double length1 = length(firstPoint, secondPoint);
        double length2 = length(firstPoint, thirdPoint);
        double length3 = length(secondPoint, thirdPoint);
        if ( (length1 + length2 <= length3) ||
                (length1 + length3 <= length2) ||
                (length2 + length3 <= length1)
        ){
            throw new IllegalArgumentException();
        }
    }

    private static double length(Point point1, Point point2){
        return Math.sqrt(
                Math.pow(point1.getX() - point2.getX(), 2) +
                Math.pow(point1.getY() - point2.getY(), 2)
        );
    }

    @Override
    public double square() {
        double length1 = length(firstPoint, secondPoint);
        double length2 = length(firstPoint, thirdPoint);
        double length3 = length(secondPoint, thirdPoint);
        double p = (length1+length2+length3)/2;
        return Math.sqrt(p*(p-length1)*(p-length2)*(p-length3));
    }

    @Override
    public double perimeter() {
        double length1 = length(firstPoint, secondPoint);
        double length2 = length(firstPoint, thirdPoint);
        double length3 = length(secondPoint, thirdPoint);
        return length1+length2+length3;
    }

    @Override
    public void move(double dx, double dy) {
        firstPoint.setX(firstPoint.getX()+dx);
        firstPoint.setY(firstPoint.getY()+dy);

        secondPoint.setX(secondPoint.getX()+dx);
        secondPoint.setY(secondPoint.getY()+dy);

        thirdPoint.setX(thirdPoint.getX()+dx);
        thirdPoint.setY(thirdPoint.getY()+dy);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "A=" + firstPoint +
                ", B=" + secondPoint +
                ", C=" + thirdPoint +
                super.toString() +
                '}';
    }

}
