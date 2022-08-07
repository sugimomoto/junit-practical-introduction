package org.example.practice;

import org.example.rule.OSDependent;
import org.example.rule.RunOn;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MultiLineStringTest {

    @Rule
    public OSDependent osDependent = new OSDependent();

    @Test
    @RunOn(RunOn.OS.WINDOWS)
    public void HelloとWorldをjoinメソッドに与えると改行で結合した文字が取得できる(){
        String ls = System.getProperty("line.separator");
        String expected = "Hello" + ls + "World" + ls;
        String[] lines = new String[]{"Hello","World"};
        String result = MultiLineString.join(lines);

        assertThat(result,is(expected));
    }

}
