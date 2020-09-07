package com.zn.juc.timeutil.Queue.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {


    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(15);


        for (int i = 0; i < 15; i++) {
            strings.put("a:"+i);
        }

        System.out.println("阻塞到这?1111");
        strings.take();
        strings.put("b");
        System.out.println("阻塞到这?222");
        System.out.println(strings.size());
    }

}
