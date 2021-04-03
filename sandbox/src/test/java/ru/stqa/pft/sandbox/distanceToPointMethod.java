package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class distanceToPointMethod {
  @Test
  public void TestArea () {
    Point p1 = new Point (5,9);
    Point p2 = new Point (2,5);
    Assert.assertEquals (p1.distanceToPointMethod(p2),6.0);
  }
  @Test
  public void TestArea1 () {
    Point p1 = new Point (5,9);
    Point p2 = new Point (2,5);
    Assert.assertEquals (p2.distanceToPointMethod(p1),5.0);
  }
  @Test
  public void TestArea2 () {
    Point p1 = new Point (1000005,1000009);
    Point p2 = new Point (1000002,1000005);
    Assert.assertEquals (p1.distanceToPointMethod(p2),5.0);
  }
  @Test
  public void TestArea3 () {
    Point p1 = new Point (0,0);
    Point p2 = new Point (3,4);
    Assert.assertEquals (p1.distanceToPointMethod(p2),5.0);
  }
  @Test
  public void TestArea4 () {
    Point p1 = new Point (3,4);
    Point p2 = new Point (0,0);
    Assert.assertEquals (p1.distanceToPointMethod(p2),5.0);
  }
  @Test
  public void TestArea6 () {
    Point p1 = new Point (0,0);
    Point p2 = new Point (0,0);
    Assert.assertEquals (p1.distanceToPointMethod(p2),0.0);
  }
  @Test
  public void TestArea7 () {
    Point p1 = new Point (-6,-10);
    Point p2 = new Point (-9,-14);
    Assert.assertEquals (p1.distanceToPointMethod(p2),5.0);
  }
}
