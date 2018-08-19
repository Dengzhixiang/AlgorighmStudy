package com.test;

import java.util.Scanner;

/**
 * 〈s〉
 *
 * @author Administrator
 * @create 2018/8/11
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
            if (i == 0) {
                sum[i] = a[i];
            } else {
                sum[i] = a[i] + sum[i - 1];
            }
        }
        int m = sc.nextInt();
//        int[] q = new int[m];
        for (int i = 0; i < m; ++i) {
            int q = sc.nextInt();
            int result = 1;
            for (int j = n - 1; j > -1; j--) {
                if (q > sum[j]) {
                    result = j + 1 + 1;
                    break;
                }
                if (q == sum[j]) {
                    result = j;
                    break;
                }
            }
            System.out.println(result);
//            System.out.println(erfen(sum, q));
        }
    }
    private static int erfen(int[] sum, int target) {
        int head = 0, tail = sum.length - 1;
        while (head <= tail) {
            int middle = (head + tail) / 2;
            if (sum[middle] > target) {
                tail = middle - 1;
            } else if (sum[middle] < target) {
                head = middle + 1;
            }
        }
        return sum[tail];
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] a = new int[n];
//        int[] t = new int[n];
//        for (int i = 0; i < n; ++i) {
//            a[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; ++i) {
//            t[i] = sc.nextInt();
//        }
//        int sum = 0;
//        int max = -10000;
//        for (int i = 0; i < n; ++i) {
//            if (t[i] == 1) {
//                sum += a[i];
//            } else if (t[i] == 0) {
//                int temp = a[i];
//                for (int j = i + 1; j < i + k && j < n; ++j) {
//                    if (t[j] == 0) {
//                        temp += a[j];
//                    }
//                }
//                if (temp > max) {
//                    max = temp;
//                }
//            }
//        }
//        System.out.println(sum + max);
//    }
}