package org.example.rule;


import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OSDependentTest {

    @Rule
    public OSDependent osDependent = new OSDependent();

    @Test
    @RunOn(RunOn.OS.WINDOWS)
    public void onlyWIndows() throws Exception{
        System.out.println("test: onlyWindows");
        assertThat(File.separator,is("\\"));
    }

    @Test
    @RunOn(RunOn.OS.MAC)
    public void onlyMac() throws Exception{
        System.out.println("test: onlyMac");
        assertThat(File.separator,is("/"));
    }


}
