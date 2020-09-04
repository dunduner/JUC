package com.zn.juc.timeutil.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangning
 * @date 2020/9/3
 */
public class ConcurrentQueue {
    public static void main(String[] args) {

        ConcurrentLinkedQueue<String> strings = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            strings.offer("a:"+i);
        }

        System.out.println(strings);

        System.out.println(strings.peek());
        System.out.println(strings);

        for (int i = 0; i < 21; i++) {
            System.out.println(strings.poll());
            System.out.println(strings);
        }
    }
}
