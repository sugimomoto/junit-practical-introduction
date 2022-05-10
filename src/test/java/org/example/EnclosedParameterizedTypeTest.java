package org.example;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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


    static class Fixture {
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

