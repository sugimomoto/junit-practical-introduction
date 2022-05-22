package org.example;

import java.util.Date;

public class MethodExtractExample {

    Date date = newDate();

    Date newDate() {
        return new Date();
    }

    public void doSomething() {
        this.date = newDate();
    }
}
