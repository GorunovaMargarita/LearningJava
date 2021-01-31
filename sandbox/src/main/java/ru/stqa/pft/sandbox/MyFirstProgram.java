package ru.stqa.pft.sandbox;
public class MyFirstProgram {
  public static void main(String[] args) {
    double distance;
    //объекты класса Point
    Point p1 = new Point(5, 6);
    Point p2 = new Point(2, 2);
    //вызов функции вычисления расстояния, на вход передаём 2 объекта типа Point
    distance = distanceFunction(p1, p2);
    System.out.println("Функция. Расстояние между точками с координатами (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") равно " + distance);
    //вызов метода расчёта расстояния между точками с одним параметром
    distance = p1.distanceToPointMethod(p2);
    System.out.println("Метод с одним параметром. Расстояние между точками с координатами (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") равно " + distance);
    //вызов метода расчёта расстояния между точками с одним параметром (передаём другую точку)
    distance = p2.distanceToPointMethod(p1);
    System.out.println("Метод с одним параметром. Расстояние между точками с координатами (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") равно " + distance);
    //вызов метода расчёта расстояния между точками с двумя параметрами (передаём два объекта класса Point)
    distance = p1.distanceBetweenMethod(p1, p2);
    System.out.println("Метод с двумя параметрами. Расстояние между точками с координатами (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") равно " + distance);
  }

  //функция для расчёта расстояния между двумя точка, принимает на вход 2 объекта класса Point
  public static double distanceFunction(Point p1, Point p2) {
    double distance;
    //формула рассчёта расстояния между точками d=sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)))
    distance = Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y)));
    return distance;
  }
}