package org.example.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String firstName;

    private String lastName;

    private String email;

    public static List<Employee> load(InputStream inputStream){
        List<Employee> employeeList = new ArrayList<>();
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new InputStreamReader(inputStream));
            for (;;){

                String line = reader.readLine();

                if(line == null){
                    break;
                }

                String[] values = line.split(",");
                Employee employee = new Employee();
                employee.setFirstName(values[0]);
                employee.setLastName(values[1]);
                employee.setEmail(values[2]);
                employeeList.add(employee);
            }

            return employeeList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(reader != null){
                try{
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
