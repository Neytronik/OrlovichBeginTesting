package ru.stqa.pft.sandbox;

public class Point {

    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public  double distance(Point p){
        double sumSquare = (p.x - this.x)*(p.x - this.x) + (p.y - this.y)*(p.y - this.y);
        return Math.sqrt(sumSquare);
    }

}
