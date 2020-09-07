package com.zn.juc.timeutil.exchanger;

import java.util.concurrent.Exchanger;


public class ExchangTest2 {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exc = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    try {
                        exc.exchange("zn:" + i);
                        System.out.println(Thread.currentThread().getName() + "生产了:" + "zn:" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


        new Thread(() -> {
            while (true) {
                String data = null;
                try {
                    data = exc.exchange(null);
                    System.out.println(data);
                    if (data==null){
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
