package com.zn.juc.timeutil.A1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class LockSupportDemo {

    private static Thread t1 = null;
    private static Thread t2 = null;
    private static String[] numArray = {"1", "2", "3", "4", "5"};
    private static String[] strArray = {"A", "B", "C", "D", "E"};



    public static void main(String[] args) {
        t1 = new Thread(()->{
            for (String num : numArray) {
                System.out.println(num);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });


        t2 = new Thread(()->{
            for (String str : strArray) {
                LockSupport.park();
                System.out.println(str);
                LockSupport.unpark(t1);

            }
        });

        t1.start();
        t2.start();


    }
}
