package org.example.practice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void 引数に4と2を入力すると2が取得できる() throws Exception{
        Calculator calculator = new Calculator();
        assertThat(calculator.divide(4,2),is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に4と0を入力するとIllegalArgumentExceptionを送出する() throws Exception{
        Calculator calculator = new Calculator();
        assertThat(calculator.divide(4,0),is(2));
    }

    @Test
    public void 引数に3と2を入力すると1が取得できる() throws Exception{
        Calculator calculator = new Calculator();
        assertThat(calculator.divide(3,2),is(1));
    }
}
