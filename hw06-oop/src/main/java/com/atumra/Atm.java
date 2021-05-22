package com.atumra;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Atm implements AtmBalanceService {

  @Getter @Setter 
  private int atmBalance;

  private BanknotesStack banknotesStack;

  public Atm() {
    this.banknotesStack = new BanknotesStack();
  }
  
  public void acceptBanknote(BanknoteType insertedNote) {
    banknotesStack.putBanknoteToStack(insertedNote);
    setAtmBalance(countAtmBalance(insertedNote.getValue(), getAtmBalance()));
  }

  public Map<Integer,Integer> giveBanknotes(int sum) throws Exception {
    Map<Integer,Integer>  result = new HashMap<>();
    
    if (sum <= getAtmBalance()) {
      result = getSumWithLargestBanknote(sum, banknotesStack);
      if (result.size() == 0) throw new Exception("we have not banknote for such values");
    } else throw new Exception("you have no enough money");
    setAtmBalance(getAtmBalance()-sum);
    return result;
  
  };






}