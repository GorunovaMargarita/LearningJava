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

}
