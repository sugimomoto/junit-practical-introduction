package org.example.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUils {
    public static String toSnakeCase(String text) {

        if(text == null){
            throw new NullPointerException("text == null");
        }

        String snake = text;
        Pattern p = Pattern.compile("([A-Z])");

        for(;;){
            Matcher m = p.matcher(snake);

            if(!m.find()){
                break;
            }

            snake = m.replaceFirst("_" + m.group(1).toLowerCase());
        }

        return snake.replaceFirst("^_","");
    }
}
