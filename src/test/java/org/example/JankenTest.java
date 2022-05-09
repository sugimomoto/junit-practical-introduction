package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.example.Janken.Hand.*;
import static org.example.Janken.Result.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JankenTest {
    Janken sut;

    @Before
    public void setUp(){
        sut = new Janken();
    }

    @Test
    public void グーとチョキなら勝利() throws Exception{
        assertThat(sut.judge(GU, TYOKI),is(WIN));
    }
}
