package com.zn.juc.timeutil.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author zhangning
 * @date 2020/9/3
 */
public class TransferQueueTest {

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        String[] numArray = {"1", "2", "3", "4", "5","6"};
        String[]  strArray= {"A", "B", "C", "D", "E","F"};

        new Thread(() -> {
            for (int i = 0; i < numArray.length; i++) {
                try {
                    transferQueue.transfer(numArray[i]);
                    String num = transferQueue.take();
                    System.out.println(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < strArray.length; i++) {
                try {
                    System.out.println(transferQueue.take());
                    transferQueue.transfer(strArray[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}