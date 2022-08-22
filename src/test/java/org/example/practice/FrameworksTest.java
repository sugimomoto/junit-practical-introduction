package org.example.practice;

import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class FrameworksTest {

    @DataPoints
    public static ApplicationServer[] APP_SERVER_PARAMS = ApplicationServer.values();

    @DataPoints
    public static Database[] DATABASE_PARAMS = Database.values();

    static Map<String, Boolean> SUPPORTS = new HashMap<String, Boolean>();

    @BeforeClass
    public static void setUpClass() throws Exception{
        InputStream in = FrameworksTest.class.getResourceAsStream("/support.txt");
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new InputStreamReader(in));
            for(;;){
                String line = reader.readLine();
                if(line == null)
                    break;

                String[] params = line.split("\\|");
                SUPPORTS.put(params[0] + "-" + params[1],Boolean.valueOf(params[2]));
            }
        }finally {
            if(reader != null){
                reader.close();
            }
        }
    }

    @Theory
    public  void isSupportはtrueを返す(ApplicationServer applicationServer, Database database)throws Exception{
        assumeTrue(isSupport(applicationServer, database));
        String desc = ", ApplicationServer:" + applicationServer + ", DB:" + database;
        assertThat(desc,Frameworks.isSupport(applicationServer,database),is(true));
    }

    @Theory
    public  void isSupportはfalseを返す(ApplicationServer applicationServer, Database database)throws Exception{
        assumeTrue(!isSupport(applicationServer, database));
        String desc = ", ApplicationServer:" + applicationServer + ", DB:" + database;
        assertThat(desc,Frameworks.isSupport(applicationServer,database),is(false));
    }

    private boolean isSupport(ApplicationServer applicationServer, Database database){
        return SUPPORTS.get(applicationServer.toString() + "-" + database.toString());
    }
}
