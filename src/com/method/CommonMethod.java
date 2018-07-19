package com.method;

/**
 * 〈常用方法合集〉
 *
 * @author Administrator
 * @create 2018/6/30
 * @since 1.0.0
 */
public class CommonMethod {

    /**
     * 判断某个数是否为素数
     *
     * @param number
     * @return boolean
     */
    public static boolean isPrime(int number) {
        int temp = number;
        if (temp < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(temp + 0.5); ++i) {
            if (temp % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求最大公约数
     *
     * @param a
     * @param b
     * @return 最大公约数
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 求最小公倍数
     * @param a
     * @param b
     * @return 最小公倍数
     */
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void bfs() {

    }
}