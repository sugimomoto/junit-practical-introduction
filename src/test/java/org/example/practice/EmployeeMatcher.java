package org.example.practice;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class EmployeeMatcher extends BaseMatcher<Employee> {

    private final Employee expected;
    private String field;
    private Object expectedValue;
    private Object actualValue;

    public EmployeeMatcher(Employee expected) {
        this.expected = expected;
    }

    public static Matcher<Employee> employee(Employee expected){
        return new EmployeeMatcher(expected);
    }

    @Override
    public boolean matches(Object actual) {
        if(expected == null){
            return (actual == null);
        }

        if(!(actual instanceof Employee)){
            return false;
        }

        Employee other = (Employee)actual;

        if(notEquals(expected.getFirstName(),other.getFirstName())){
            field = "firstName";
            expectedValue = expected.getFirstName();
            actualValue = other.getFirstName();
            return false;
        }

        if(notEquals(expected.getLastName(),other.getLastName())){
            field = "lastName";
            expectedValue = expected.getLastName();
            actualValue = other.getLastName();
            return false;
        }

        if(notEquals(expected.getEmail(),other.getEmail())){
            field = "email";
            expectedValue = expected.getEmail();
            actualValue = other.getEmail();
            return false;
        }

        return true;
    }

    private boolean notEquals(Object obj, Object other) {
        if(obj == null){
            return other != null;
        }
        return !obj.equals(other);
    }

    @Override
    public void describeTo(Description description) {
        if(expected == null || field == null){
            description.appendValue(expected);
        }else{
            description.appendText(field + " is ").appendValue(expectedValue)
                    .appendValue(", but ").appendValue(actualValue);
        }
    }
}
