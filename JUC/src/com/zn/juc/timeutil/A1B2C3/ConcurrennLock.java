package com.zn.juc.timeutil.A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class ConcurrennLock {
    private static String[] numArray = {"1", "2", "3", "4", "5"};
    private static String[] strArray = {"A", "B", "C", "D", "E"};


    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionT1 = reentrantLock.newCondition();
        Condition conditionT2 = reentrantLock.newCondition();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                for (String num : numArray) {
                    System.out.println(num);

                    conditionT1.await();
                    conditionT2.signal();
                }
                conditionT2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                for (String str : strArray) {
                    System.out.println(str);
                    conditionT1.signal();
                    conditionT2.await();
                }
                conditionT1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

    }
}
