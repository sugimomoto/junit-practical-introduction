package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Enclosed.class)
public class UserDaoTest {

    public static class テーブルが空の場合 {
        UserDao sut;

        @Before
        public void setUp() throws Exception{
            DbUtils.drop("users");
            sut = new UserDao();
        }

        @Test
        public void getListで0件を取得できる() throws Exception{
            List<User> actual = sut.getList();
            assertThat(actual,is(notNullValue()));
            assertThat(actual.size(),is(0));
        }
    }

    public static class テーブルにサンプルデータが100件含まれる場合 {

        UserDao sut;

        @Before
        public void setUp() throws Exception{
            DbUtils.drop("users");
            // DbUtils.insert("users",getClass().getResource("users.yaml"))
            sut = new UserDao();
        }

        @Test
        public void getListで100件取得できる() throws Exception{
            List<User> actual = sut.getList();
            assertThat(actual, is(notNullValue()));
            assertThat(actual.size(),is(100));
        }
    }
}
