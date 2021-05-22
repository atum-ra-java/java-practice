package com.atumra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AtmTest {

    // Все тесты должны проходить, менять тесты не надо, гы

    @Test
    @DisplayName("acceptBanknote")
    void acceptBanknoteTest() {
        // given
        Atm atm = new Atm();

        // when add 1
        atm.acceptBanknote(BanknoteType.ONE);
        // then balance is 1
        assertThat(atm.getAtmBalance()).isEqualTo(1);

        // when add 10 in addition
        atm.acceptBanknote(BanknoteType.TEN);
        // then balance is 11
        assertThat(atm.getAtmBalance()).isEqualTo(11);

    }

    @Test
    @DisplayName("giveBanknotes")
    void giveBanknotesTest() {
        // given
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Integer> result1 = new HashMap<>();
        Map<Integer, Integer> result3 = new HashMap<>();

        Atm atm = new Atm();
        // when add 10 banknote
        atm.acceptBanknote(BanknoteType.TEN);

        try {
            result = atm.giveBanknotes(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then I want 10 in large
        assertThat(result.get(10)).isEqualTo(1);

        // when add 25 in banknotes and want 5
        atm.acceptBanknote(BanknoteType.TEN);
        atm.acceptBanknote(BanknoteType.TEN);
        atm.acceptBanknote(BanknoteType.FIVE);

        try {
            result1 = atm.giveBanknotes(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then I want 5 in large
        assertThat(result1.get(5)).isEqualTo(1);

        // when add 10 in 5's and want 10 in 10's
        atm.acceptBanknote(BanknoteType.FIVE);
        atm.acceptBanknote(BanknoteType.FIVE);

        try {
            result3 = atm.giveBanknotes(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then I want 10 in large if in Stack 5's and 10's
        assertThat(result3.get(10)).isEqualTo(1);
    }

    @Test
    @DisplayName("getAtmBalance")
    void getAtmBalance() {
        Atm atm = new Atm();

        // when add 8
        atm.acceptBanknote(BanknoteType.ONE);
        atm.acceptBanknote(BanknoteType.TWO);
        atm.acceptBanknote(BanknoteType.FIVE);

        // then atmBalance is 8
        assertThat(atm.getAtmBalance()).isEqualTo(8);
    }

}
