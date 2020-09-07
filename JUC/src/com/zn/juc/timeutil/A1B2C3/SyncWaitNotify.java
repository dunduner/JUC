package com.zn.juc.timeutil.A1B2C3;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class SyncWaitNotify {


    public static void main(String[] args) {
        final Object o = new Object();
        char[] numChar = "123456".toCharArray();
        char[] strChar = "ABCDEF".toCharArray();



        Thread t1 = new Thread(() -> {
          synchronized (o){
              for (char num : numChar) {
                  System.out.println(num);
                  try {
                      o.wait();
                      o.notify();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }

          }
        });
        Thread t2 = new Thread(() -> {
            synchronized (o){
                for (char str : strChar) {
                    System.out.println(str);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });


        t1.start();
        t2.start();
    }

}
