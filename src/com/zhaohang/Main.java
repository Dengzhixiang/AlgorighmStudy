package com.zhaohang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 〈招商银行信用卡中心 --> 笔试〉
 *
 * @author Administrator
 * @create 2018/9/16
 * @since 1.0.0
 */
public class Main {



    private static int[] array = new int[]{0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    public static void main(String[] args) {
        problem1();
//        problem2();
//        problem3();
    }

    public static void problem1() {
        Scanner scanner = new Scanner(System.in);
        String[] childrensString = scanner.nextLine().split(" ");
        String[] sizeString = scanner.nextLine().split(" ");
        int[] childrens = new int[childrensString.length];
        int[] sizes = new int[sizeString.length];
        int result = 0;
        for (int i = 0; i < childrensString.length; ++i) {
            childrens[i] = Integer.valueOf(childrensString[i]);
        }
        for (int i = 0; i < sizeString.length; ++i) {
            sizes[i] = Integer.valueOf(sizeString[i]);
        }
        Arrays.sort(childrens);
        Arrays.sort(sizes);
        int j = 0;
        for (int i = 0; i < sizes.length; ++i) {
            while (j < childrens.length && sizes[i] >= childrens[j]) {
                result++;
                j++;
                break;
            }
        }
        System.out.println(result);
    }

    public static void problem2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(f(n));
    }

    public static int f(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }

    public static void problem3() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;
        for (int i = 1; i <= N; ++i) {
            if (isRight(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isRight(int n) {
        char[] input = String.valueOf(n).toCharArray();
        char[] temp = new char[input.length];
        for (int i = 0; i < input.length; ++i) {
            int index = array[(int) input[i] - 48];
            if (index == -1) {
                return false;
            }
            temp[i] = (char) (index + 48);
        }
        if (Integer.valueOf(String.valueOf(temp)) == n) {
            return false;
        }
        return true;
    }
}