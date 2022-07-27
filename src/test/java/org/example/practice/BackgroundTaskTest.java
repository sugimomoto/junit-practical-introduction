package org.example.practice;

import org.checkerframework.checker.units.qual.C;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class BackgroundTaskTest {

    @Rule
    public Timeout timeout = new Timeout(1000);

    @Test
    public void invokeで別スレッドで実行される() throws Exception{
        final AtomicReference<String> backgounrThreadName = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                backgounrThreadName.set(Thread.currentThread().getName());
                latch.countDown();
            }
        };

        BackgroundTask sut = new BackgroundTask(task);
        sut.invoke();
        latch.await();

        assertThat(backgounrThreadName.get(),is(not(Thread.currentThread().getName())));


    }
}
