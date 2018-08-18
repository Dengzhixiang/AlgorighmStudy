package com.concrurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/14 14:22
 */
public class ProducerAndComsumer {

    private static Lock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();
    private static int count = 0;

    static class Consumer implements Runnable {

        public void consume() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0) {
                    notEmpty.await();
                }
                count--;
                System.out.println("Consume a good");
                notFull.signal();
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; ++i) {
                try {
                    consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Producer implements Runnable {

        public void produce() throws InterruptedException {
            lock.lock();
            try {
                while (count == 10) {
                    notFull.await();
                }
                count++;
                System.out.println("Produce a good");
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; ++i) {
                try {
                    produce();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Consumer());
        executorService.execute(new Producer());
    }

}
