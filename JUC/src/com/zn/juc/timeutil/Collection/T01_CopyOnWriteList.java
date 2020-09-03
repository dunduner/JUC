package com.zn.juc.timeutil.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * @author zhangning
 * @date 2020/9/3
 */
public class T01_CopyOnWriteList {

    public static void main(String[] args) {
        List<String> lists
//                = new CopyOnWriteArrayList<>();//2494
//        = new ArrayList<>();
        = new Vector<>();//75
        Random random = new Random();
        Thread[] threads  = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
//                     100个线程 一个线程写入1000次  共10万个
                    for (int j = 0; j < 1000; j++) {
                        lists.add("a:"+random.nextInt(10000));
                    }
                }
            };
            threads[i] = new Thread(runnable);
        }

        runAndComputeTime(threads);
        System.out.println(lists.size());

        System.out.println("==========================");
        System.out.println("模拟读操作");
        System.out.println("==========================");
        Thread[] threads1 = new Thread[100];
        for (int i = 0; i <threads1.length ; i++) {
            Runnable runnable2 = new Runnable() {
                @Override
                public void run() {
//                     100个线程 一个线程读1000次
                    for (int j = 0; j < 10000; j++) {
                        lists.get(random.nextInt(10000));
                    }
                }
            };
            threads1[i] = new Thread(runnable2);
        }
        long s1 = System.currentTimeMillis();
        List<Thread> threadsList = Arrays.asList(threads1);
        threadsList.forEach(thread -> thread.start());
        threadsList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println("读操作耗时:"+(s2-s1));
    }

    static  void runAndComputeTime(Thread[] threads){
        long s1 = System.currentTimeMillis();

        List<Thread> threads1 = Arrays.asList(threads);
        threads1.forEach(thread -> thread.start());
        threads1.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println("耗时:"+(s2-s1));
    }

}