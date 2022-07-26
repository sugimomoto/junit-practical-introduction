package org.example.practice;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class ItemStockTest {

    public static class 初期状態の場合{
        ItemStock sut;
        Item book;

        @Before
        public void setUp(){
            book = new Item("book",3800);
            sut = new ItemStock();
        }

        @Test
        public void getNumで0が取得できる(){
            assertThat(sut.getNum(book),is(0));
        }

        @Test
        public void addでItemを追加するとgetNumで1が取得できる(){
            sut.add(book);
            assertThat(sut.getNum(book),is(1));
        }
    }

    public static class Itemが一つ追加されている場合{
        ItemStock sut;
        Item book;

        @Before
        public void setUp(){
            book = new Item("book",3800);
            sut = new ItemStock();
            sut.add(book);
        }

        @Test
        public void getNumで1が取得できる(){
            assertThat(sut.getNum(book),is(1));
        }

        @Test
        public void addで同じ名前のItemを追加するとgetNumで2が取得できる(){
            sut.add(book);

            assertThat(sut.getNum(book),is(2));
        }

        @Test
        public void addで異なるItemを追加するとgetNumで1が取得できる(){
            Item bike = new Item("bike",57000);
            sut.add(bike);

            assertThat(sut.getNum(bike),is(1));
            assertThat(sut.getNum(book),is(1));
        }

    }

}
