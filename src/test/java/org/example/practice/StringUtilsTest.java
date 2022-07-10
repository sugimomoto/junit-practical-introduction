package org.example.practice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringUtilsTest {

    @Test
    public void aaaを入力するとaaaが取得できる(){
        assertThat(StringUils.toSnakeCase("aaa"),is("aaa"));
    }

    @Test
    public void HelloWorldを入力するとhello_worldが取得できる(){
        assertThat(StringUils.toSnakeCase("HelloWorld"),is("hello_world"));
    }

    @Test
    public void practiceJunitを入力するとpractice_junitが取得できる(){
        assertThat(StringUils.toSnakeCase("practiceJunit"),is("practice_junit"));
    }
}
