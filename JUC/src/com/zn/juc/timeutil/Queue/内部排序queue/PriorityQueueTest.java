package com.zn.juc.timeutil.Queue.内部排序queue;

import java.util.PriorityQueue;

/**
 * @author zhangning
 * @date 2020/9/3
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add("2");
//        priorityQueue.add("23");
//        priorityQueue.add("12");
//        priorityQueue.add("88");
//        priorityQueue.add("1");
//        priorityQueue.add("4");

        priorityQueue.add("a");
        priorityQueue.add("z");
        priorityQueue.add("fz");
        priorityQueue.add("b");
        priorityQueue.add("ddd");
        priorityQueue.add("fa");
        priorityQueue.add("hz");

        for (int i = 0; i < 7; i++) {
            System.out.println(priorityQueue.poll());
        }
    }
}
