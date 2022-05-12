package org.example;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.Member;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeTrue;

@RunWith(Enclosed.class)
public class EnclosedParameterizedTypeTest{

    @RunWith(Theories.class)
    public static class 引数がint型のテスト {

        @DataPoint
        public static int INT_PARAM_1 = 3;

        @DataPoint
        public static int INT_PARAM_2 = 4;

        public 引数がint型のテスト(){
            System.out.println("引数がint型のテスト:初期化");
        }

        @Theory
        public void 引数がint型のテストメソッド(int param) throws Exception{
            System.out.println("引数がint型のテストメソッド("+ param +")");
        }
    }


    @RunWith(Theories.class)
    public static class Stringのパラメータ化テスト {

        @DataPoint
        public static String STRING_PARAM_1 = "Hello";

        @DataPoint
        public static String STRING_PARAM_2 = "World";

        public Stringのパラメータ化テスト(){
            System.out.println("Stringのパラメータ化テスト:初期化");
        }

        @Theory
        public void 引数がint型のテストメソッド(String param) throws Exception{
            System.out.println("引数がString型のテストメソッド("+ param +")");
        }
    }


    @RunWith(Theories.class)
    public static class 引数がmultiple型のテスト {

        // 複数パターン入れることもできる。しかもすべての組み合わせテストが実行されるので便利
        @DataPoint
        public static int INT_PARAM_1 = 3;

        @DataPoint
        public static int INT_PARAM_2 = 4;

        @DataPoint
        public static String STRING_PARAM_1 = "Hello";

        @DataPoint
        public static String STRING_PARAM_2 = "World";

        @Theory
        public void 引数がint型のテストメソッド(int intParam, String stringParam) throws Exception{
            System.out.println("引数がMultiple型のテストメソッド(" + intParam + ")(" + stringParam + ")");
        }
    }

    @RunWith(Theories.class)
    public static class 引数がmultipleだけどInt一種類のテスト {

        @DataPoint
        public static int INT_PARAM_1 = 3;

        @DataPoint
        public static int INT_PARAM_2 = 4;

        @DataPoint
        public static int INT_PARAM_3 = 5;
        @Theory
        public void 引数がint型のテストメソッド(int x, int y) throws Exception{
            System.out.println("引数がmultipleだけどInt一種類のテスト(" + x + ")(" + y + ")");
        }
    }


    @RunWith(Theories.class)
    public static class CalculatorDataPointTest {

        @DataPoint
        public static Fixture PARAM_1 = new Fixture(3, 4, 7);

        @DataPoint
        public static Fixture PARAM_2 = new Fixture(0, 5, 5);

        @DataPoint
        public static Fixture PARAM_3 = new Fixture(-1, 3, 2);

        @Theory
        public void addTest(Fixture param) throws Exception{
            Calculator calculator = new Calculator();
            assertThat(calculator.add(param.x, param.y),is(param.expected));
        }
    }


    @RunWith(Theories.class)
    public static class CalculatorDataPointsTest {

        @DataPoints
        public static Fixture[] PARAMs = {
                new Fixture(3, 4, 7),
                new Fixture(0, 5, 5),
                new Fixture(-1, 3, 2)
        };

        @Theory
        public void addTest(Fixture param) throws Exception{
            Calculator calculator = new Calculator();
            assertThat(calculator.add(param.x, param.y),is(param.expected));
        }
    }

    @RunWith(Theories.class)
    public static class CalculatorDataPointsYamlTest{

        @DataPoints
        public static Fixture[] getParams(){
            InputStream in = CalculatorDataPointsYamlTest.class.getResourceAsStream("/params.yaml");
            List<Fixture> fixtureList = (List<Fixture>)new Yaml().load(in);
            Fixture[] fixtures = (fixtureList).toArray(new Fixture[0]);
            return fixtures;
        }

        @Theory
        public void add(Fixture p) throws Exception{
            Calculator sut = new Calculator();
            assertThat(sut.add(p.x,p.y),is(p.expected));
        }
    }

    @RunWith(Theories.class)
    public static class MemberTest{

        @DataPoints
        public static int[] AGES = {15, 20, 25, 30};

        @DataPoints
        public static Gender[] GENDERS = Gender.values();

        @Theory
        public void canEntryは25再以下の女性の場合にtrueを返す(int age, Gender gender) {
            assumeTrue(age <= 25 && gender == Gender.FEMALE);
            System.out.println("age: " + age +  " / gender: " + gender);
            assertThat(canEntry(age, gender),is(true));
        }

        @Theory
        public void canEntryは25再以下の女性でない場合にfalseを返す(int age, Gender gender){
            assumeTrue(25 < age || gender != Gender.FEMALE);
            System.out.println("age: " + age +  " / gender: " + gender);
            assertThat(canEntry(age,gender),is(false));
        }

        private boolean canEntry(int age, Gender gender) {
            return true;
        }

        private static enum Gender {
            MAN,FEMALE
        }
    }


    public static class WindowsOnlyTest{

        // なるほど。環境依存系の前提条件を弾くのに利用できるね。良いね。
        @Test
        public void windows環境では改行はrn(){
            assumeTrue(System.getProperty("os.name").contains("Windows"));
            assertThat(System.getProperty("line.separator"),is("\r\n"));
        }
    }



    public static class Fixture {
        int x;
        int y;
        int expected;

        Fixture(int x, int y, int expected){
            this.x = x;
            this.y = y;
            this.expected = expected;
        }
    }


}

