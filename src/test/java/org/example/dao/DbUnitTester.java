package org.example.dao;


import org.dbunit.AbstractDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class DbUnitTester extends AbstractDatabaseTester implements TestRule {
    @Override
    public IDatabaseConnection getConnection() throws Exception {
        return null;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return null;
    }
}
