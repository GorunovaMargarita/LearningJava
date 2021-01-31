package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceToPointMethod(Point p) {
    double distance;
    //формула рассчёта расстояния между точками d=sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)))
    distance = Math.sqrt(((x - p.x) * (x - p.x)) + ((y - p.y) * (y - p.y)));
    return distance;
  }

  public double distanceBetweenMethod(Point p1, Point p2) {
    double distance;
    //формула рассчёта расстояния между точками d=sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)))
    distance = Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y)));
    return distance;
  }
}
