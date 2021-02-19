package com.lzl.spring.server.effect.blockingqueue;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolDemo {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Thread.sleep(65000L);
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    prints();
                    return null;
                }
            });

        }


    }


    public static void prints() {
        System.out.println(String.format("thread:【%s】",Thread.currentThread().getName()));
    }

}