package com.test;

import java.util.Scanner;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/13 19:04
 */
public class Test2 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * 计算两点之间的绝对距离
         * @param p
         * @return
         */
        public int getLength(Point p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        // Point[0] 为派件员起点
        Point[] points = new Point[n + 1];
        points[0] = new Point(0, 0);
        for (int i = 1; i < n + 1; ++i) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            points[i] = new Point(x, y);
        }
//        System.out.println(dfs(points));
    }

    private static int min = Integer.MAX_VALUE;

    /**
     *
     * @param points
     * @return
     */
    private static void dfs(Point[] points, int value) {
        if (value > min) {
            return;
        }

    }
}
