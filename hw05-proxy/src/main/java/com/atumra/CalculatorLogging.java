package com.atumra;

public interface CalculatorLogging {

  @Log
  public void calculate(int param); 
  
  public void calculate(int param1, int param2);

  @Log
  public void calculate(int param1, int param2, String param3);

}