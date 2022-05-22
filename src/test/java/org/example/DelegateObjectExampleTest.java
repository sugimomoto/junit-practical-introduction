package org.example;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class DelegateObjectExampleTest {

    @Test
    public void doSomethingTest()throws Exception{
        final Date current = new Date();
        DelegateObjectExample sut = new DelegateObjectExample();
        sut.dateFactory = new DateFactory(){
            @Override
            public Date newDate(){
                return current;
            }
        };

        sut.doSomething();
        assertThat(sut.date, is(sameInstance(current)));
    }
}
