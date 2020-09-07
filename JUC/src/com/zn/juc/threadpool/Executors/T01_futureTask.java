package com.zn.juc.threadpool.Executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class T01_futureTask {


    public static void main(String[] args) {
        FutureTask<Integer> integerFutureTask = new FutureTask<>(()->{
            return 11;
        });


        new Thread(integerFutureTask).start();
        try {
            System.out.println( integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
