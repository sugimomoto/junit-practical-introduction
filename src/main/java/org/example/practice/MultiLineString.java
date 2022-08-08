package org.example.practice;

public class MultiLineString {

    public static String join(String... lines){
        if(lines == null){
            return null;
        }

        String ls = System.getProperty("line.separator");
        StringBuilder text = new StringBuilder();

        for (String line : lines) {
            text.append(line != null ? line : "").append(ls);
        }

        return text.toString();
    }
}
