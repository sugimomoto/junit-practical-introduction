package org.example;

import java.util.Date;

public class DelegateObjectExample {

    DateFactory dateFactory = new DateFactory();
    Date date = new Date();

    public void doSomething(){
        this.date = dateFactory.newDate();
    }
}
