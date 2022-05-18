package org.example.rule;

import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class AppServer extends ExternalResource {


    @Override
    protected void before() throws Throwable{
        System.out.println("start AP");
    }

    @Override
    protected void after(){
        System.out.println("shutdown AP");
    }

}
