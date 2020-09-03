package com.zn.juc.timeutil.Queue.生产者消费者模型;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangning
 * @date 2020/9/3
 */
public class LinkedBlockQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> strs = new LinkedBlockingQueue<>();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a:" + i);
                    System.out.println("生产了:"+"a:" + i);
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producter").start();


        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (; ; ) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "|||" + strs.take());
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer"+i).start();
        }

    }
}
