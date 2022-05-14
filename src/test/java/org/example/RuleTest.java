package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Enclosed.class)
public class RuleTest {

    public static class TimeOutRuleTest{
        @Rule
        public Timeout timeout = new Timeout(1000);

        @Test
        public void 時間がかかるテスト(){
            // 省略
        }
    }

    public static class TemporaryFolderExcampleTest{
        @Rule
        public TemporaryFolder temporaryFolder = new TemporaryFolder();

        @Test
        public void mkDefaultFilesで2つのファイルが作成される() throws Exception{
            File folder = new File(temporaryFolder.getRoot() + "/sample");
            folder.mkdir();

            assertThat(folder.list().length,is(1));

        }
    }

    public static class TemporaryFolderExtendTest{

        @Rule
        public SpecificTemporaryFolder specificTemporaryFolder = new SpecificTemporaryFolder();

        @Test
        public void subfoderTest() throws Exception{
            File rootFolder = specificTemporaryFolder.getRoot();

            assertThat(rootFolder.list().length, is(2));
        }

    }


}
