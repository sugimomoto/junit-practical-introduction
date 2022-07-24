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

        @Before
        public void setUp(){
            sut = new ItemStock();
        }

        @Test
        public void getNumで0が取得できる(){
            Item item = new Item("itemX",100);
            assertThat(sut.getNum(item),is(0));
        }

        @Test
        public void addでItemを追加するとgetNumで1が取得できる(){
            Item item = new Item("itemX",100);
            sut.add(item);
            assertThat(sut.getNum(item),is(1));
        }
    }
}
