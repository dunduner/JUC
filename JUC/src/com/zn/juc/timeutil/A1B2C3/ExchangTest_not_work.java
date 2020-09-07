package com.zn.juc.timeutil.A1B2C3;
import java.util.concurrent.Exchanger;


public class ExchangTest_not_work {
    private static String[] numArray = {"1", "2", "3", "4", "5"};
    private static String[] strArray = {"A", "B", "C", "D", "E"};
    private static Exchanger<String> exc = new Exchanger<>();
    public static void main(String[] args) {

        new Thread(()->{

            for (String num : numArray) {
                System.out.println(num);
                try {
                    exc.exchange(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()->{
            for (String str : strArray) {
                try {
                    exc.exchange(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(str);
            }

        }).start();
    }
}
