package com.shenxinfu;

import java.util.Scanner;

/**
 * 〈深信服笔试〉
 *
 * @author Administrator
 * @create 2018/9/21
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        problem1();
    }

    public static void problem1() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; ++j) {
                array[j] = scanner.nextInt();
            }
            System.out.println(solution(array));
        }
    }

    private static int solution(int[] array) {
        int result = 0;

        return result;
    }

    public static void problem2() {

    }

    public static void problem3() {

    }

}