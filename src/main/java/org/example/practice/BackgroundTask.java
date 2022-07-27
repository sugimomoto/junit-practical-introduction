package org.example.practice;

import java.util.concurrent.Executors;

public class BackgroundTask {

    private final Runnable task;

    public BackgroundTask(Runnable task){
        this.task = task;
    }

    public void invoke(){
        Executors.newSingleThreadExecutor().execute(task);
    }
}
