package org.example.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.example.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DbUnitTest {

    @Rule
    public DbUnitTester tester = new DbUnitTester("org.h2.Driver", "jdbc:h2:C:/Work/h2/db;SCHEMA=ut", "sa", "sa", "ut") {

        @Override
        protected void before() throws Exception{
            executeQuery("DROP TABLE IF EXISTS users");
            executeQuery("CREATE TABLE users(id INT AUTO_INCREMENT, name VARCHAR(255))");
        }

        @Override
        protected IDataSet createDataSet() throws Exception {
            return new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream("/fixtures.xml"));
        }
    };

    @Test
    public void SelectTest() throws SQLException {
        UserDao userDao = new UserDao();

        List<String> users = userDao.getList();

        assertThat(users.size(),is(2));

        assertThat(users.get(0),is("Ichigo"));
        assertThat(users.get(1),is("Jiro"));
    }
};
