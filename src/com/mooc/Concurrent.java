package com.mooc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 〈Java并发编程与高并发解决方案〉
 *
 * @author Administrator
 * @create 2018/6/22
 * @since 1.0.0
 */
//@Slf4j
public class Concurrent {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static long count = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; ++i) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
//                    log.info("count:{}", count);
                    System.out.println(count);
                }
            });
        }
    }

    private static void add() {
        count++;
    }
}