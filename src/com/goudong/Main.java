package com.goudong;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 〈京东考试 --> 完全多路图〉
 *
 * @author Administrator
 * @create 2018/9/9
 * @since 1.0.0
 */
public class Main {

    private static int[][] map;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int T = cin.nextInt();
            for (int i = 0; i < T; ++i) {
                int n = cin.nextInt();
                int m = cin.nextInt();
                map = new int[n + 1][n + 1];
                for (int j = 0; j < m; ++j) {
                    int x = cin.nextInt();
                    int y = cin.nextInt();
                    map[x][y] = 1;
                    map[y][x] = 1;
                }
                if (dfs(n + 1)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public static boolean dfs(int n) {
        // 对每个点，先找出其连接的点
        // 再找出其不连接的点
        // 枚举不连接的点找出其所连接的点
        // 判断是否重合
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                if (i == j) {
                    // 连接点集合
                    Set<Integer> set1 = getLinkedPoints(i, n);
                    // 不连接点集合
                    Set<Integer> set2 = getNotLinkPoints(set1, n);
                    for (Integer temp : set2) {
                        Set<Integer> set3 = getLinkedPoints(temp, n);
                        if (!set3.containsAll(set1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static Set<Integer> getNotLinkPoints(Set<Integer> set1, int n) {
        Set<Integer> set2 = new HashSet<>();
        for (int i = 1; i < n; ++i) {
            if (!set1.contains(i)) {
                set2.add(i);
            }
        }
        return set2;
    }

    public static Set getLinkedPoints(int x, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; ++i) {
            if (i != x) {
                if (map[x][i] == 1) {
                    set.add(i);
                }
                if (map[i][x] == 1) {
                    set.add(i);
                }
            }
        }
        return set;
    }
}