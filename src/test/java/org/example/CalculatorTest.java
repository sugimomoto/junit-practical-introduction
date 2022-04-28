package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Before
    public void setUp(){
        System.out.println("setUp");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
    }

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

    @Test(expected = IllegalArgumentException.class)
    public void divideで5と0のときillegalArgumentExceptionを創出する(){
        Calculator calculator = new Calculator();
        calculator.divide(5,0);
    }

    @Test(timeout = 100L)
    public void timeoutTest(){
        Calculator calculator = new Calculator();
        calculator.divide(5,0);
    }

    @Ignore
    @Test
    public void ignoreTest() throws Exception {
        throw new Exception();
    }


}