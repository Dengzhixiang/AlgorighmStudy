package com.concrurent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAandBReentrantLock {

    private ReentrantLock lock = new ReentrantLock();
    Condition aCondition = lock.newCondition();
    Condition bCondition = lock.newCondition();

    public static void main(String[] args) {
        PrintAandBReentrantLock test = new PrintAandBReentrantLock();
        test.new AOutput().start();
        test.new BOutput().start();
    }

    class AOutput extends Thread {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println("A");
                    bCondition.signal();
                    aCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class BOutput extends Thread {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println("B");
                    aCondition.signal();
                    bCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
