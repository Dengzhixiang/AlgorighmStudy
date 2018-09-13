package com.concrurent;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/14 10:35
 */
public class WaitNotify {

    static boolean flag = true;

    static Object lock = new Object();

    public static void main(String[] args) {

    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {

                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("1");
            }
        }
    }

    class Notify implements Runnable {

        @Override
        public void run() {

        }
    }

}
