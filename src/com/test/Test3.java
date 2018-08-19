package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
<<<<<<< HEAD
 * 〈s〉
 *
 * @author Administrator
 * @create 2018/8/13
 * @since 1.0.0
 */
public class Test3 {
    public static void main(String[] args) {
        print();
    }
    public static void print() {
        Object object = new Object();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new Printer("Printer1", object));
        pool.execute(new Printer("Printer2", object));
    }

    static class Printer implements Runnable{
        private Object object;
        private String name;
        private AtomicInteger num;

        public Printer(String name, Object object) {
            this.object = object;
            this.name = name;
            num = new AtomicInteger(1);
        }


        @Override
        public void run() {
            if (name.equals("Printer1")) {
                while (num.get() <= 100) {
                    synchronized(object) {
                        System.out.println(name + " — " + num);
                        num.incrementAndGet();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (name.equals("Printer2")) {
                while (num.get() <= 100) {
                    synchronized(object) {
                        System.out.println(name + " — " + num);
                        num.incrementAndGet();
                        object.notify();
                    }
                }
            }

        }

    }



}
=======
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/13 21:13
 */
public class Test3 {

}
>>>>>>> 783a67f67c1bf5ed7379d59528ab2d85f2d9b7a2
