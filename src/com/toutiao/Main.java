package com.toutiao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 〈网易笔试〉
 *
 * @author Administrator
 * @create 2018/9/8
 * @since 1.0.0
 */
public class Main {

    //    private static int N = 0;
    private static int[] X = {0, 0, -1, 1};
    private static int[] Y = {1, -1, 0, 0};

    public static void main(String[] args) {
//        problem1();
//        problem2();
//        problem3();
//        problem4();
        problem5();
    }

    private static void problem5() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < m; ++i) {
                int x = cin.nextInt();
                int y = cin.nextInt();
                map[x][y] = 1;
            }
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == j) {

                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static void problem4() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int N = cin.nextInt();
            if (N == 1) {
                int temp = cin.nextInt();
                if (temp < 127) {
                    System.out.println(1);
                }
            }
            int[] array = new int[N];
            for (int i = 0; i < N; ++i) {
                array[i] = cin.nextInt();
            }
        }
    }


    public static void problem1() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String string = cin.nextLine();
            noRepeatMaxLength(string);
        }
    }

    public static void noRepeatMaxLength(String temp) {
        char[] chars = temp.toCharArray();
        Set<Character> set = new HashSet<>();
        int sum = 0, i = 0, j = 0;
        while (i < chars.length && j < chars.length) {
            if (set.contains(chars[j])) {
                set.remove(chars[i++]);
            } else {
                set.add(chars[j++]);
                sum = Math.max(sum, j - i);
            }
        }
        System.out.println(sum);
    }

    public static void problem2() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int m = cin.nextInt();
            int[][] array = new int[m][m];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < m; ++j) {
                    array[i][j] = cin.nextInt();
                }
            }
            int sum = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (array[i][j] != 0) {
                        dfs(array, i, j, m);
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    public static void dfs(int[][] array, int x, int y, int n) {
        array[x][y] = 0;
        for (int i = 0; i < 4; ++i) {
            int nx = x + X[i];
            int ny = y + Y[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && array[nx][ny] != 0) {
                dfs(array, nx, ny, n);
            }
        }
    }

    public static void problem3() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String ip = cin.nextLine();
            System.out.println(solution(ip));

        }
    }

    private static int solution(String ip) {
        char[] array = ip.toCharArray();
        if (array.length == 4 || array.length == 12) {
            return 1;
        }
        int sum = 0;
        for (int j = 1; j < array.length; ++j) {
            for (int k = j + 1; k < array.length; ++k) {
                for (int l = k + 1; l < array.length; ++l) {
                    if (j < 3 && k - j < 3 && l - k < 3) {
                        if (check(ip, j, k, l)) {
                            sum++;
                        }
                    }
                }
            }

        }
        return sum;
    }

    private static boolean check(String ip, int j, int k, int l) {
        if (ip.substring(0, j).startsWith("0") && j != 1) {
            return false;
        }
        if (ip.substring(j, k).startsWith("0") && k - j != 1) {
            return false;
        }
        if (ip.substring(k, l).startsWith("0") && l - k != 1) {
            return false;
        }
        if (ip.substring(l).startsWith("0") && ip.length() - l != 1) {
            return false;
        }
        return true;
    }
}