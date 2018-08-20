package com.test;

import java.util.Scanner;

/**
 * 〈AliKuaiDi〉
 *
 * @author Administrator
 * @create 2018/8/13
 * @since 1.0.0
 */
public class AliKuaiDi {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * 计算两点之间的绝对距离
         *
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
        System.out.println(send(points, n));
    }

    /**
     * 枚举除起点外其他派件点的各种组合，并计算其距离，保留最小距离
     *
     * @param points
     * @param n
     * @return
     */
    private static int send(Point[] points, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = i + 1; j < n + 1; ++j) {
                swap(points, i, j);
                int result = calc(points);
                if (result < min) {
                    min = result;
                }
            }
        }
        return min;
    }

    /**
     * 交换 Points 数组两个 Point 的位置
     *
     * @param points
     * @param i
     * @param j
     */
    private static void swap(Point[] points, int i, int j) {
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    /**
     * 按照 Ponts 数组的顺序计算距离，最后加上从最后一个派送点返回的距离
     *
     * @param points
     * @return
     */
    private static int calc(Point[] points) {
        int sum = 0;
        for (int i = 1; i < points.length; ++i) {
            sum += points[i].getLength(points[i - 1]);
        }
        return sum + points[points.length - 1].getLength(points[0]);
    }
}