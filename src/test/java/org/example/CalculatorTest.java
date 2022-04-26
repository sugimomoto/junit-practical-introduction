package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void multiplyで3と4の乗算結果が取得できる() {
        Calculator calculator = new Calculator();
        int expected = 12;
        int actual = calculator.multiply(3,4);

        assertThat(actual,is(expected));
    }

    @Test
    public void multiplyで5と7の乗算結果が取得できる() {
        Calculator calculator = new Calculator();
        int expected = 35;
        int actual = calculator.multiply(5,7);

        assertThat(actual,is(expected));
    }

    @Test
    public void divideで3と2の除算結果が取得できる() {
        Calculator calculator = new Calculator();
        float expected = 1.5f;
        float actual = calculator.divide(3,2);

        assertThat(actual, is(expected));
    }
}