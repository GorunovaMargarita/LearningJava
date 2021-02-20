package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
  @Test
  public void testPrimes() {
    Assert.assertTrue(Prime.isPrimeFast(Integer.MAX_VALUE));
  }
  @Test
  public void testNonPrimes() {
    Assert.assertFalse(Prime.isPrime(Integer.MAX_VALUE-2));
  }
  @Test
  public void testPrimesWhile() {
    Assert.assertTrue(Prime.isPrimeWhile(Integer.MAX_VALUE));
  }
  @Test
  public void testNonPrimesWhile() {
    Assert.assertFalse(Prime.isPrimeWhile(Integer.MAX_VALUE-2));
  }
  @Test
  public void testPrimeslong() {
    long n= Integer.MAX_VALUE;
    Assert.assertTrue(Prime.isPrime(n));
  }
  @Test (enabled = false)
  public void testNonPrimeslong() {
    long n= Integer.MAX_VALUE-2;
    Assert.assertFalse(Prime.isPrime(n));
  }
}
