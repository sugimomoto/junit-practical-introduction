package org.example;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IsDate extends BaseMatcher<Date> {

    private final int yyyy;
    private final int mm;
    private final int dd;

    private Object actual;

    public IsDate(int yyyy, int mm, int dd) {
        this.yyyy = yyyy;
        this.mm = mm;
        this.dd = dd;
    }

    public static Matcher<Date> dateOf(int yyyy, int mm, int dd){
        return new IsDate(yyyy, mm, dd);
    }

    @Override
    public boolean matches(Object actual) {
        this.actual = actual;

        if(!(actual instanceof Date)){
            return false;
        }

        Calendar calendar = Calendar.getInstance();

        calendar.setTime((Date)actual);

        if(this.yyyy != calendar.get(Calendar.YEAR)){
            return false;
        }

        if(this.mm != calendar.get(Calendar.MONTH)){
            return false;
        }

        if(this.dd != calendar.get(Calendar.DATE)){
            return false;
        }

        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(String.format("%d/%02d/%02d",yyyy,mm,dd));
        if(actual != null){
            description.appendText(" but actual is");
            description.appendValue(
                    new SimpleDateFormat("yyyy/MM/dd").format((Date) actual)
            );
        }
    }

}
