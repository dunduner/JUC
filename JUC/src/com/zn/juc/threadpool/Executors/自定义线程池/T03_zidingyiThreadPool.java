package com.zn.juc.threadpool.Executors.自定义线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class T03_zidingyiThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10, 10, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new MyRejected());
        long t1 =System.currentTimeMillis();
        for (int i = 1; i <=10 ; i++) {
            pool.execute(new MyTask(i, "任务:"+i));
            System.out.println("活跃的线程数："+pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());
        }
        System.out.println("over");
        pool.shutdown();
        long t2 =System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
