package com.zn.juc.timeutil.A1B2C3;

import java.util.concurrent.*;


/**
 * @author zhangning
 * @date 2020/9/4
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws Exception {
        char[] numChar = "123456".toCharArray();
        char[] strChar = "ABCDEF".toCharArray();
        BlockingQueue<String> abq1 = new ArrayBlockingQueue(1);
        BlockingQueue<String> abq2 = new ArrayBlockingQueue(1);


        new Thread(() -> {
            for (char c : numChar) {
                System.out.println(c);
                try {
                    abq1.take();
                    abq2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


        new Thread(() -> {
            for (char str : strChar) {
                System.out.println(str);
                try {
                    abq1.put("ok");
                    abq2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
