package com.zn.juc.threadpool.Executors.callable;

import java.util.concurrent.*;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class CallAbleDemo {


    public static void main(String[] args) throws Exception {
        Callable<String> stringCallable = new Callable<>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                TimeUnit.SECONDS.sleep(2);
                return "hello callable";
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(stringCallable);

        System.out.println("完成了");
        String s = submit.get();//阻塞
        System.out.println(s);
        System.out.println(executorService.isShutdown());
        executorService.shutdown();


    }
}
