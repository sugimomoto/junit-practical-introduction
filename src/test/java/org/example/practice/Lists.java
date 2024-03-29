package org.example.practice;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.List;

public class Lists {

    public static <T> Matcher<List<?>> list(T... items){
        return new ListMatcher(items);
    }

    static class ListMatcher extends BaseMatcher<List<?>> {
        final Object[] items;
        List<?> actual;
        boolean matches = false;
        int idx = 0;

        ListMatcher(Object[] items){
            this.items = items;
        }

        @Override
        public boolean matches(Object actual) {
            if(!(actual instanceof List)){
                return false;
            }
            List<?> list = (List<?>)actual;
            this.actual = list;

            if(list.size() != items.length){
                return false;
            }

            for(Object obj : list){
                Object other = items[idx];
                if(obj != null && !obj.equals(other)){
                    return false;
                }else if(obj == null && other != null){
                    return false;
                }
                idx++;
            }
            return true;
        }

        @Override
        public void describeTo(Description description) {
            if(actual == null){
                description.appendValue(items);
            }else{
                description.appendValue(items[idx]).appendText(", but ")
                        .appendValue(actual.get(idx))
                        .appendText(" at index of " + idx);
            }
        }
    }
}
