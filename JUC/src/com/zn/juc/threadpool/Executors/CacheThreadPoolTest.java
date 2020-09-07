package com.zn.juc.threadpool.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i <10 ; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName()+"执行了");
            });
        }
        executorService.shutdown();
    }
}
