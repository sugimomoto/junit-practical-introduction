package org.example.practice;

import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class EmployeeTest {

    @Test
    public void loadでEmployeeの一覧を取得できる(){
        InputStream input = getClass().getResourceAsStream("Employee.txt");

        List<Employee> employeeList = Employee.load(input);

        assertThat(employeeList,is(notNullValue()));
        assertThat(employeeList.size(),is(1));
        Employee employee = employeeList.get(0);

        assertThat(employee.getFirstName(),is("Ichiro"));
        assertThat(employee.getLastName(),is("Tanaka"));
        assertThat(employee.getEmail(),is("ichiro@example.com"));
    }
}
