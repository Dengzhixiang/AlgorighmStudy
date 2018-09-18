package com.safe360;

import java.util.Scanner;

/**
 * 〈360 --> 笔试〉
 *
 * @author Administrator
 * @create 2018/9/17
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        problem2();
    }

    /**
     * Bits
     * 小明在课上学习了进制转化。现在他有q个询问，每次询问
     * 想问你在[l,r]区间内，k进制表示中，k-1的数量最多的数是哪个数。
     * 比如当k=2时，9的二进制就是1001，那么他就有2个1。
     */
    public static void problem2() {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; ++i) {
            int k = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(resolve(k, l, r));
        }
    }

    private static int resolve(int k, int l, int r) {
        // i 个 k
        for (int i = 1; ; ++i) {
            int temp = calc(k, i);
            System.out.println(temp);
            if (temp > r) {
                return calc(k, i - 1);
            }
        }
//        return 0;
    }

    private static int calc(int k, int n) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int temp = k;
            for (int j = 0; j < n - 1; ++j) {
                temp = temp * k;
            }
            result += (temp * (k - 1));
        }
        return result;
    }
}