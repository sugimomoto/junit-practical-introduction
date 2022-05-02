package org.example;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class ParameterTest {

    @DataPoints
    public static int[][] VALUES = {
            {0,0,0},
            {0,1,1},
            {1,0,1},
            {3,4,7}
    };

    @Theory
    public void add(int[] values)throws Exception{
        Calculator calculator = new Calculator();
        assertThat(calculator.add(values[0],values[1]), is(values[2]));
    }

}
