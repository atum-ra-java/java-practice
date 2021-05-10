package com.atumra;

public class Launch {
  public static void main(String[] args) {
    CalculatorLogging myClass = Ioc.createCalculator();
    System.out.println("one arg");
    myClass.calculate(3);
    System.out.println("two args not logged");
    myClass.calculate(3, 3);
    System.out.println("three args");
    myClass.calculate(3, 3, "sum");
    System.out.println("все");
  }

}