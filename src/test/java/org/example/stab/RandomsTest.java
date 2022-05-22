package org.example.stab;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RandomsTest {

    @Test
    public void choiceでAを返す() throws Exception{
        List<String> options = Arrays.asList("A","B");

        Randoms sut = new Randoms();

        sut.generator = new RandomNumberGenerator() {
            @Override
            public int nextInt() {
                return 0;
            }
        };

        assertThat(sut.choice(options),is("A"));
    }

    @Test
    public void choiceでBを返す() throws Exception{
        List<String> options = Arrays.asList("A","B");

        Randoms sut = new Randoms();

        sut.generator = new RandomNumberGenerator() {
            @Override
            public int nextInt() {
                return 1;
            }
        };

        assertThat(sut.choice(options),is("B"));
    }

}
