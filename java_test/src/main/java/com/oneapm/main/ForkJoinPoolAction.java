package com.oneapm.main;

import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolAction {
    public static void main(String[] args) throws InterruptedException {
//        PrintTask task = new PrintTask(0, 300);
//        //创建实例，并执行分割任务
//        ForkJoinPool pool = new ForkJoinPool();
//        pool.submit(task);
//        //线程阻塞，等待所有任务完成
//        pool.awaitTermination(2, TimeUnit.SECONDS);
//        pool.shutdown();

        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);

    }
}

class PrintTask extends RecursiveAction {
    private static final int THRESHOLD = 10; //最多只能打印50个数
    private int start;
    private int end;

    public PrintTask(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值：" + i);
            }
        } else {
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            //并行执行两个“小任务”
            left.fork();
            right.fork();
        }
    }
}