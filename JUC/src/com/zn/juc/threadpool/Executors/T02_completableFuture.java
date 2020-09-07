package com.zn.juc.threadpool.Executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class T02_completableFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> taobao = CompletableFuture.supplyAsync(() -> taobao());
        CompletableFuture<Double> jingdong = CompletableFuture.supplyAsync(() -> jd());
        CompletableFuture<Double> pinduoduo = CompletableFuture.supplyAsync(() -> pdd());

        System.out.println("阻塞前");
        CompletableFuture.allOf(taobao, jingdong, pinduoduo).join();//allOf 所有结束就取消阻塞
//        CompletableFuture.anyOf(taobao, jingdong, pinduoduo).join();//anyOf 又一个结束就取消阻塞

        System.out.println("阻塞后 ");
        System.out.println(taobao.get());
        System.out.println(jingdong.get());
        System.out.println(pinduoduo.get());


//        CompletableFuture.supplyAsync(() -> pdd())
//                .thenApply(String::valueOf)
//                .thenApply(str -> "price:" + str)
//                .thenAccept(System.out::println);
//
//        try {
//            System.in.read();
//        } catch (IOException e) {

//            e.printStackTrace();
//        }

    }

    public static Double taobao() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1.00;
    }

    public static Double jd() {
        try {
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2.00;
    }

    public static Double pdd() {
        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0.50;
    }
}
