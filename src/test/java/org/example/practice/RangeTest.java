package org.example.practice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RangeTest {

    @Test
    public void min0_0かつmax10_5のRangeの時(){
        Range range = new Range(0.0, 10.5);

        assertThat(range.contains(-0.1),is(false));
        assertThat(range.contains(0.0),is(true));
        assertThat(range.contains(10.5),is(true));
        assertThat(range.contains(10.6),is(false));
    }

    @Test
    public void min_5_1かつmax5_1のRangeの時(){
        Range range = new Range(-5.1, 5.1);

        assertThat(range.contains(-5.2),is(false));
        assertThat(range.contains(-5.1),is(true));
        assertThat(range.contains(5.1),is(true));
        assertThat(range.contains(5.2),is(false));
    }
}
