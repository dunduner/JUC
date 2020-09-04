package com.zn.juc.timeutil.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author zhangning
 * @date 2020/9/3
 */
public class TransferQueueTest {
    private static String threadAName;
    private static String threadBName;

    public static void main(String[] args) throws InterruptedException {
        TransferQueue transferQueue = new LinkedTransferQueue<String>();
        String[] numArray = {"1", "2", "3", "4", "5"};
        String[] strArray = {"A", "B", "C", "D", "E"};

        new Thread(() -> {
            for (int i = 0; i < strArray.length; i++) {
                try {
                    System.out.println(transferQueue.take());
                    System.out.println(strArray[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i < numArray.length; i++) {
            transferQueue.transfer(numArray[i]);
        }

    }
}