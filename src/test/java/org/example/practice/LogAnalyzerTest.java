package org.example.practice;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogAnalyzerTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void LogLoaderが例外を創出するときAnalyzeExceptionが再送出される() throws Exception{
        // Setup
        LogAnalyzer sut = new LogAnalyzer();
        final IOException errorCause = new IOException("error by stub");

        LogLoader mockLoader = mock(LogLoader.class);
        sut.logLoader = mockLoader;
        when(mockLoader.load("test")).thenThrow(errorCause);
        ex.expect(LogAnalyzer.AnalyzeException.class);
        ex.expectMessage("error by stub");
        ex.expect(new BaseMatcher<Object>(){
            Throwable cause;

            @Override
            public boolean matches(Object item){
                Throwable t = (Throwable)item;
                cause = t.getCause();
                return cause == errorCause;
            }

            @Override
            public void describeTo(Description description){
                description.appendValue(cause);
            }
        });

        sut.analyze("test");
    }
}
