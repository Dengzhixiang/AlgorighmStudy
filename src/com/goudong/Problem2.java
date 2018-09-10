package com.goudong;

import java.util.*;

/**
 * 〈京东考试 -> 对比〉
 *
 * @author Administrator
 * @create 2018/9/9
 * @since 1.0.0
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<Good> goods = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            goods.add(new Good(a, b, c));
        }
        Collections.sort(goods);
//        for (Good good : goods) {
//            System.out.println(good);
//        }
        int sum = 0;
        Set<Good> noHeGe = new HashSet<>();
        Iterator<Good> iterator = goods.iterator();
        while (iterator.hasNext()) {
            Good good = iterator.next();
            Iterator<Good> iterator1 = goods.iterator();
            while (iterator1.hasNext()) {
                Good good1 = iterator1.next();
                if (good.compare(good1) && !noHeGe.contains(good)) {
                    sum++;
                    noHeGe.add(good);
                }
            }
        }
        System.out.println(sum);
    }

    static class Good implements Comparable {
        int a, b, c;

        public Good(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        /**
         * 判断是否被temp搞成不合格
         *
         * @param temp
         * @return
         */
        public boolean compare(Good temp) {
            if (temp.a > a && temp.b > b && temp.c > c) {
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Object o) {
            Good temp = (Good) o;
            if (a != temp.a) {
                return a - temp.a;
            }
            if (b != temp.b) {
                return b - temp.b;
            }
            return c - temp.c;
        }

        @Override
        public String toString() {
            return "Good{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }


}