package com.tavisca.workshops.second.threadpooling;

import java.util.concurrent.Callable;

public class SimpleCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
