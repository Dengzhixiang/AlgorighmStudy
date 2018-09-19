package com.concrurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈两个线程之间轮流打印AB〉
 *
 * @author Administrator
 * @create 2018/9/19
 * @since 1.0.0
 */
public class PrintAandBSynchronized {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Object lock = new Object();
        executorService.execute(new Printer(lock, "A"));
        executorService.execute(new Printer(lock, "B"));
    }

    static class Printer implements Runnable {
        private Object lock;
        private String value;

        public Printer(Object lock, String value) {
            this.lock = lock;
            this.value = value;
        }


        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    System.out.println(value);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}