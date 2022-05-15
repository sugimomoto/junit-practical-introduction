package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.*;
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

    public static class VerifierExampleTest {

        @Rule
        public Verifier verifier = new Verifier() {
            @Override
            protected void verify() throws Throwable {
                // 一番最後に実行されるのでログファイルの検証やオブジェクトの廃棄、Close後の検証などに利用する
                System.out.println("4. verifier");
            }
        };

        @Before
        public void setUp(){
            System.out.println("1. before");
        }

        @After
        public void tearDown(){
            System.out.println("3. after");
        }

        @Test
        public void veryfierTest(){
            System.out.println("2. test");
        }
    }

    public static class ErrorCollectorTest{

        @Rule
        public ErrorCollector ec = new ErrorCollector();

        @Test
        public void DefaultConstractorTest() throws Exception{
            Calculator calculator = new Calculator();

            ec.checkThat(calculator.add(1,2),is(3));
            ec.checkThat(calculator.add(2,2),is(3));
            ec.checkThat(calculator.add(3,2),is(5));
            ec.checkThat(calculator.add(1,1),is(3));
        }

    }

    public static class ExceptedExceptionExampleTest{
        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        @Test
        public void 例外の発生とメッセージを検証するテスト() throws Exception{
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("argument is null");
            throw new IllegalArgumentException("argument is null");
        }


    }


}
