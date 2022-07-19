package org.example.practice;

public class Counter {

    private int count;

    public Counter(){
        count = 0;
    }
    public int increment() {
        return ++count;
    }
}
