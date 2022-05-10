package org.example;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class YamlSetup {

    @Test
    public void getTotalPrice() throws Exception{

        // SetUp
        BookStore sut = new BookStore();
        Book book = (Book)new Yaml().load(getClass().getResourceAsStream("/book.yaml"));

        assertThat(book.getTitle(),is("Refactoring"));
    }

    @Test
    public void mapYaml() throws Exception{
        Map sample = new HashMap<String,String>();
        sample.put("first","hello");
        sample.put("last","world");

        Yaml yaml = new Yaml();
        String actual = yaml.dump(sample);

        assertThat(actual,is("first: hello\n\rlast: world"));


    }

    @Test
    public void generateYaml() throws Exception{
        User user = new User();
        user.setName("Hello Yaml");
        user.setAge(23);

        Yaml yaml = new Yaml();
        assertThat(yaml.dump(user),is("name: HelloYaml\n\rage: 23"));


    }

}
