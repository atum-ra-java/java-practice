package com.atumra;

public class Calculator implements CalculatorLogging{
  
  @Override
  public void calculate(int param) {}; 

  @Override
  public void calculate(int param1, int param2) {};
  
  public void calculateA(int param1, int param2) {};

  @Log
  @Override
  public void calculate(int param1, int param2, String param3) {};
}