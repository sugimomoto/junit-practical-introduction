package org.example.rule;

import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;

public class DBServer extends ExternalResource {

    @Override
    protected void before() throws Throwable{
        System.out.println("start DB");
    }

    @Override
    protected void after(){
        System.out.println("shutdown DB");
    }
}
