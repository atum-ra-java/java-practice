package com.atumra;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface AtmBalanceService {
  public int getAtmBalance();

  default int countAtmBalance(int value, int balance) {
    return value + balance;
  };

  default Map<Integer, Integer> getSumWithLargestBanknote(int sum, BanknotesStack stack) {
    Map<Integer, Integer> banknotesForCash = new HashMap<>();

    Integer[] valuesOfNotes = Stream.of(BanknoteType.values())
      .map(BanknoteType::getValue)
      .collect(Collectors.toSet())
      .toArray(new Integer[0]);

    Arrays.sort(valuesOfNotes, Collections.reverseOrder());

    int[] noteCounter = new int[valuesOfNotes.length];

    // count notes using Greedy approach
    for (int i = 0; i < valuesOfNotes.length; i++) {
      var sumOfValue = stack.getSumForValue().get(valuesOfNotes[i]);
      
      if (sum >= valuesOfNotes[i] && sumOfValue >= valuesOfNotes[i]) {
        noteCounter[i] = sum / valuesOfNotes[i];
        sum = sum - noteCounter[i] * valuesOfNotes[i];
        banknotesForCash.put(valuesOfNotes[i], noteCounter[i]);
      }
    }

    return banknotesForCash;
  };

}