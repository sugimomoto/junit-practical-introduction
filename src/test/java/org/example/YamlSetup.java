package org.example;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class YamlSetup {

    @Test
    public void getTotalPrice() throws Exception{

        // SetUp
        BookStore sut = new BookStore();
        Book book = (Book)new Yaml().load(getClass().getResourceAsStream("book.yaml"));

        assertThat(book.getTitle(),is("Refactoring"));
    }
}
