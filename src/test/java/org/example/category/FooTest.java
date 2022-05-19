package org.example.category;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;

public class FooTest {

    @Category(FastTest.class)
    @Test
    public void fastTest() throws Exception{
        System.out.println("fasttest");
    }

    @Category(SlowTest.class)
    @Test
    public void slowTest() throws Exception{
        System.out.println("slowtest");
    }
}
