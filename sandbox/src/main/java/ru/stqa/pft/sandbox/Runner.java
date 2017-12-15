package ru.stqa.pft.sandbox;

public class Runner {
    public static void main(String[] args) {
        Point p1 = new Point(1.0, 2.3);
        Point p2 = new Point(1.0, 3.2);
        System.out.println(Point.distance(p1, p2));
    }
}
