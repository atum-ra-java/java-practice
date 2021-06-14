package com.atumra;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class BanknotesStack {


  private Map<BanknoteType,Integer>  banknotesInStack = new HashMap<>();

  public BanknotesStack() {
    banknotesInStack.put(BanknoteType.ONE, 0);
    banknotesInStack.put(BanknoteType.TWO, 0);
    banknotesInStack.put(BanknoteType.FIVE, 0);
    banknotesInStack.put(BanknoteType.TEN, 0);
  }

  public void putBanknoteToStack(BanknoteType banknote) {
    banknotesInStack.put(banknote, banknotesInStack.get(banknote)+1);
  };

  public Map<Integer, Integer> getSumForValue() {
    Map<Integer, Integer> result = new HashMap<>();

    for (Map.Entry<BanknoteType,Integer> entry : banknotesInStack.entrySet()) {
      var sum = entry.getKey().getValue() * entry.getValue();

      result.put(entry.getKey().getValue(), sum); 
    }
    return result;
  }


}