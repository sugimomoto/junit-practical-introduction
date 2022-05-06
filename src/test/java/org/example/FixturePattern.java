package org.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FixturePattern {

    /**
     * Inline Setup
     * テストメソッドごとにフィクスチャを整える
     * @throws Exception
     */
    @Test
    public void isEmptyOrNullは空文字列でtrueを返す() throws Exception{
        // SetUp
        String input = "";
        boolean expected = true;

        // Exercise
        boolean actual = StringUtil.isEmptyOrNull(input);

        // Verify
        assertThat(actual,is(expected));

    }
}
