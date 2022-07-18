package org.example.practice;

public class Calculator {
    public int divide(int x, int y) throws IllegalArgumentException {

        if(y == 0){
            throw  new IllegalArgumentException("第2引数に0は利用できません。");
        }

        return x / y;
    }
}
