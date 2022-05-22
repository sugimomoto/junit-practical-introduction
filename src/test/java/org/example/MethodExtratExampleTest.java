package org.example;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class MethodExtratExampleTest {

    @Test
    public void doSomethingTest() throws Exception{
        final Date curretn = new Date();
        MethodExtractExample sut = new MethodExtractExample(){
            @Override
            Date newDate(){
                return curretn;
            }
        };

        sut.doSomething();

        assertThat(sut.date, is(sameInstance(curretn)));
    }
}
