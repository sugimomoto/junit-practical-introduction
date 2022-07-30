package org.example.practice;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    @Test
    public void createFizzBuzzListで16まで取得できる(){
        List<String> list = FizzBuzz.createFizzBuzzList(16);

        assertThat(list.size(),is(16));

        assertThat(list.get(0),is("1"));
        assertThat(list.get(1),is("2"));
        assertThat(list.get(2),is("Fizz"));
        assertThat(list.get(3),is("4"));
        assertThat(list.get(4),is("Buzz"));
        assertThat(list.get(5),is("Fizz"));
        assertThat(list.get(6),is("7"));
        assertThat(list.get(7),is("8"));
        assertThat(list.get(8),is("Fizz"));
        assertThat(list.get(9),is("Buzz"));
        assertThat(list.get(10),is("11"));
        assertThat(list.get(11),is("Fizz"));
        assertThat(list.get(12),is("13"));
        assertThat(list.get(13),is("14"));
        assertThat(list.get(14),is("FizzBuzz"));
        assertThat(list.get(15),is("16"));

    }
}
