package com.concrurent;

/**
 * 〈单例模式〉
 *
 * @author Administrator
 * @create 2018/6/18
 * @since 1.0.0
 */
public class Singleton {

    public static Singleton getInstance() {
        return LazySingletonHolder.singleton;
    }

    private static class LazySingletonHolder {
        static Singleton singleton = new Singleton();
    }
}