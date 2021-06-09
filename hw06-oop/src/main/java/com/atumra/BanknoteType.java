package com.atumra;

public enum BanknoteType {
  ONE(1), 
  TWO(2), 
  FIVE(5),
  TEN(10);

  private final int value;

  private BanknoteType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
 

}