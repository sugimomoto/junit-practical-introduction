package org.example.mockito;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

public class MockItoTest {

    @Test
    public void MockItoListTest(){
        List<String> mock = mock(List.class);
        assertThat(mock.get(0),is(nullValue()));
        assertThat(mock.contains("Hello"),is(false));

        when(mock.get(0)).thenReturn("Hello");

        assertThat(mock.get(0),is("Hello"));
    }
}
