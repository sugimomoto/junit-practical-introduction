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

    @Test
    public void MockItoListThrowTest(){
        List<String> mock = mock(List.class);
        assertThat(mock.get(0),is(nullValue()));

        when(mock.get(0)).thenReturn("Hello");
        when(mock.get(1)).thenReturn("World");
        when(mock.get(2)).thenThrow(new IndexOutOfBoundsException());

        assertThat(mock.get(0),is("Hello"));
        assertThat(mock.get(1),is("World"));
        assertThat(mock.get(2),is("Error"));
    }

    @Test
    public void MockItoListVoidTest(){
        List<String> mock = mock(List.class);

        doThrow(new RuntimeException()).when(mock).clear();
        mock.clear();
    }

    @Test
    public void MockItoListArgumentTest(){
        List<String> mock = mock(List.class);
        when(mock.get(anyInt())).thenReturn("Hello");

        assertThat(mock.get(0),is("Hello"));
        assertThat(mock.get(1),is("Hello"));
        assertThat(mock.get(999),is("Hello"));
    }


    @Test
    public void MockItoListVerifyTest(){
        List<String> mock = mock(List.class);

        mock.clear();
        mock.add("Hello");
        mock.add("Hello");

        verify(mock).clear();
        verify(mock,times(2)).add("Hello");
        verify(mock,never()).add("World");

    }

}
