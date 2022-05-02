package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.example.IsDate.dateOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class CalculatorTest {

    public static class EnclosedA{
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
            int actual = calculator.multiply(5, 7);

            assertThat(actual, is(expected));
        }

        @Test
        public void divideで3と2の除算結果が取得できる() {
            Calculator calculator = new Calculator();
            float expected = 1.5f;
            float actual = calculator.divide(3, 2);

            assertThat(actual, is(expected));
        }
    }

    public static class EnclosedB {

        @Test(expected = IllegalArgumentException.class)
        public void divideで5と0のときillegalArgumentExceptionを創出する() {
            Calculator calculator = new Calculator();
            calculator.divide(5, 0);
        }

        @Test(timeout = 100L)
        public void timeoutTest() {
            Calculator calculator = new Calculator();
            calculator.divide(5, 0);
        }

        @Test
        public void fialTest() {
            fail("未実装テスト");
        }

        @Test
        public void hasItemsTest() {
            List<String> actualList = Arrays.asList("Hello", "World");
            assertThat(actualList, hasItems("Hello"));
        }

        @Test
        public void objectCompareTest() {
            User actual = new User();
            actual.setName("Hello");
            actual.setAge(30);

            User expect = new User();
            expect.setName("World");
            expect.setAge(30);

            assertThat(actual, is(expect));
        }

        @Test
        public void isNotTest() {
            Calculator calculator = new Calculator();

            assertThat(14, is(not(calculator.multiply(1, 2))));
        }

        @Test
        public void isNullValueTest() {
            String actual = null;

            assertThat(actual, is(nullValue()));
        }

        @Test
        public void isNotNullValueTest() {
            String actual = "";

            assertThat(actual, is(notNullValue()));
        }

        @Test
        public void sameInstanceTest() {
            Calculator actual = new Calculator();
            Calculator expect = actual;

            assertThat(actual, is(sameInstance(expect)));
        }

        @Test
        public void instanceOfTest() {
            Calculator calculator = new Calculator();

            assertThat(calculator, is(instanceOf(Calculator.class)));
        }

        @Ignore
        @Test
        public void ignoreTest() throws Exception {
            throw new Exception();
        }

        @Test
        public void originalMatcherTest() {
            assertThat(new Date(), is(dateOf(2020, 1, 1)));
        }

        public static void main(String[] args) {
            org.junit.runner.JUnitCore.main(CalculatorTest.class.getName());
        }
    }
}