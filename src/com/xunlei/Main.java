package com.xunlei;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * 〈迅雷笔试 --> 后台开发工程师〉
 *
 * @author Administrator
 * @create 2018/9/12
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
//        problem1();
        problem2();
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static boolean isHuZhi(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static void problem1() {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int sum = 0;
        Set<Temp> temps = new HashSet<>();
        for (int a = 1; a <= n; ++a) {
            for (int b = 1; b <= n; ++b) {
                for (int c = 1; c <= n; ++c) {
                    int temp = a * a + b * b;
                    Temp temp2 = new Temp(a, b, c);
                    if (!temps.contains(temp2) && temp == c * c && isHuZhi(a, b) && isHuZhi(b, c) && isHuZhi(a, c)) {
                        sum++;
                        temps.add(temp2);
                        int aa = a * 1;
                        int bb = b * 1;
                        int cc = c * 1;
                        for (int i = 2; aa < n && bb < n && cc < n; i++) {
                            aa = aa * i;
                            bb = bb * i;
                            cc = cc * i;
                            Temp temp4 = new Temp(aa, bb, cc);
                            temps.add(temp4);
                            sum++;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static void problem2() {
        Scanner cin = new Scanner(System.in);
        int A = cin.nextInt();
        int B = cin.nextInt();
        int current = 0;
        int MaxSum = 0;
        // 第一次尝试，先放整数A
        int[] array = new int[7];
        for (int i = 0; i < 17; ++i) {

        }
        // 第二次尝试，先放整数B
        for (int j = 0; j < 17; ++j) {

        }
    }

    static class Temp {
        int a, b, c;

        public Temp(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Temp temp = (Temp) o;
            return a == temp.a && b == temp.b && c == temp.c
                    || a == temp.b && b == temp.a && c == temp.c;
        }

        @Override
        public int hashCode() {
            if (a > b) {
                int temp3 = b;
                b = a;
                a = temp3;
            }
            return Objects.hash(a, b, c);
        }
    }
}