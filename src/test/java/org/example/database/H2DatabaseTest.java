package org.example.database;

import org.h2.util.JdbcUtils;
import org.junit.Rule;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class H2DatabaseTest {

    @Rule
    public H2DatabaseServer server = new H2DatabaseServer("C:/Work/h2","db","ut");

    @Test
    public void ReadTest() throws SQLException, ClassNotFoundException {
        System.out.println( "Hello World!" );

        Class.forName ("org.h2.Driver");
        Connection conn = DriverManager.getConnection ("jdbc:h2:C:/Work/h2/db", "sa","sa");

        Statement st = conn.createStatement();

        st.execute("DROP TABLE IF EXISTS TEST;");
        st.execute("CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));");
        st.execute("INSERT INTO TEST VALUES(1, 'Hello');");

        ResultSet rs = st.executeQuery("SELECT * FROM TEST");

        int count = 0;

        while(rs.next()){
            if(count == 0){
                assertThat(rs.getString("ID"),is("1"));
                assertThat(rs.getString("NAME"),is("Hello"));
            }
        }

    }
}
