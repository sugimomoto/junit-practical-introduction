package org.example.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Rule;

public class DbUnitTest {

    @Rule
    public DbUnitTester tester = new DbUnitTester("org.h2.Driver", "jdbc:h2:tcp//localhost/db;SCHEMA=ut", "sa", "", "ut") {

        @Override
        protected void before() throws Exception{
            executeQuery("DROP TABLE IF EXISTS users");
            executeQuery("CREATE TABLE users(id INT AUTO_INCREMENT, name VARCHAR(255))");
        }

        @Override
        protected IDataSet createDataSet() throws Exception {
            return new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream("fixtures.xml"));
        }
    };


};
