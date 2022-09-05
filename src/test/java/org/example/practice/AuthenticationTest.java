package org.example.practice;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Enclosed.class)
public class AuthenticationTest {

    public static class アカウントが存在しない場合 {
        Authentication sut;

        @Before
        public void setUp() throws Exception {
            sut = new Authentication();
            sut.accountDao = mock(AccountDao.class);
            when(sut.accountDao.findOrNull("user001")).thenReturn(null);
        }

        @Test
        public void authenticateはnullを返す() throws Exception{
            assertThat(sut.authenticate("user001","pw123"),is(nullValue()));
        }
    }

    public static class アカウントが存在しパスワードが一致する場合{
        Authentication sut;
        Account account;

        @Before
        public void setUo() throws Exception{
            sut = new Authentication();
            sut.accountDao = mock(AccountDao.class);
            account = new Account("user001","pw123");
            when(sut.accountDao.findOrNull("user001")).thenReturn(account);
        }

        @Test
        public void authenticateはaccountお返す() throws Exception{
            assertThat(sut.authenticate("user001","pw123"),is(sameInstance(account)));
        }
    }

    public static class アカウントが存在するがパスワードが一致しない場合{
        Authentication sut;
        Account account;

        @Before
        public void setUo() throws Exception{
            sut = new Authentication();
            sut.accountDao = mock(AccountDao.class);
            account = new Account("user001","pw999");
            when(sut.accountDao.findOrNull("user001")).thenReturn(account);
        }

        @Test
        public void authenticateはaccountお返す() throws Exception{
            assertThat(sut.authenticate("user001","pw999"),is(nullValue()));
        }
    }
}
