package org.example.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    public List<String> getList() throws SQLException{
        ResultSet rs = createStatement().executeQuery("SELECT name FROM users");

        LinkedList<String> result = new LinkedList<>();

        while (rs.next()){
            result.add(rs.getString(1));
        }

        return result;
    }

    public void insert(String username) throws SQLException{
        String sql = "INSERT INTO users(name) VALUES(" + username + ")";
        createStatement().executeUpdate(sql);
    }

    public Statement createStatement() throws SQLException{
        String url = "jdbc:h2:C:/Work/h2/db;SCHEMA=ut";
        Connection connection = DriverManager.getConnection(url,"sa","sa");
        return connection.createStatement();
    }
}
