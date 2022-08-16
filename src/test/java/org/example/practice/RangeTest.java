package org.example.practice;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class RangeTest {

    @RunWith(Enclosed.class)
    public static class Rangeが0から10_5で{

        @RunWith(Theories.class)
        public static class かつ範囲外の場合{
            Range sut;

            @Before
            public void setUp(){
                sut = new Range(0d,10.5);
            }

            @DataPoints
            public static double[] VALUES = {-0.1, 10.6};

            @Theory
            public void containsはfalseを返す(double value) throws Exception{
                assertThat("value="+value,sut.contains(value),is(false));
            }
        }

        @RunWith(Theories.class)
        public static class かつ範囲内の場合{
            Range sut;

            @Before
            public void setUp(){
                sut = new Range(0d,10.5);
            }

            @DataPoints
            public static double[] VALUES = {0.0, 10.5};

            @Theory
            public void containsはtrueを返す(double value) throws Exception{
                assertThat("value="+value,sut.contains(value),is(true));
            }
        }
    }
}
