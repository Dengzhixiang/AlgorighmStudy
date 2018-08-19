package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/13 21:24
 */
public class Test4 {

    //题目3：
/*
请使用线程池并实现两个线程，使之交替打印1 - 100，如：两个线程分别为：Printer1 和 Printer2，最后输出结果为：
Printer1 — 1
Printer2 — 2
Printer1 — 3
Printer2 — 4
...
Printer1 - 99
Printer2 - 100
*/

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new Printer("Printer1", semaphore));
        Thread.sleep(50);
        pool.execute(new Printer("Printer2", semaphore));
        Thread.sleep(50);
//        pool.execute(new Printer("Printer3", semaphore));

    }


    static class Printer implements Runnable {
        private String name;
        private Semaphore semaphore;
        private static final int MAX_COUNT = 100;
        private static AtomicInteger num = new AtomicInteger(1);

        public Printer(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while (num.get() <= MAX_COUNT) {
                try {
                    semaphore.acquire();
                    System.out.println(name + " -- " + num.get());
                    num.incrementAndGet();
                    semaphore.release();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
