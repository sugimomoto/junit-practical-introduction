package org.example.practice;

import java.util.Arrays;

public class MultiLineString {

    public static String join(String[] lines){
        String result = "";
        String ls = System.getProperty("line.separator");

        for (int i = 0; i < lines.length; i++) {
            result += lines[i] + ls;
        }
        return result;
    }
}
