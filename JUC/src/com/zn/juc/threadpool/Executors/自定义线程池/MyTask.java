package com.zn.juc.threadpool.Executors.自定义线程池;

/**
 * @author zhangning
 * @date 2020/9/4
 */
public class MyTask implements Runnable {
    private int taskId;
    private String taskName;

    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public MyTask(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }
    @Override
    public void run() {
        try {
            //模拟干活 干了10秒钟
            Thread.sleep(3000);
            System.out.println("=taskId:" + taskId + ",taskName:" + taskName+",任务执行完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
