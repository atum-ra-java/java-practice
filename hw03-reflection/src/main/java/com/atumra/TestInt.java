package com.atumra;

import com.atumra.annotation.After;
import com.atumra.annotation.Before;
import com.atumra.annotation.Test;

import static com.atumra.Framework.*;

public class TestInt {

    int x;
    int y;

    @Before
    public void initVariable() {
        x = 100;
    }

    @Test
    public void integerXEquals0() throws Exception {
        compareInt(x, 100);
    }

    @Test
    public void integerYEquals100() throws Exception {
        compareInt(y, 100);
    }

    @After
    public void printValue() {
        System.out.println("Значение переменной х " + String.valueOf(x));
        System.out.println("Значение переменной y " + String.valueOf(y));
    }

}