package com.xiaomi;

import java.util.*;

/**
 * 〈小米 --> 笔试〉
 *
 * @author Administrator
 * @create 2018/9/20
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        problem1();
    }

    /**
     * 定义：数值序列中包含2~16进制整数，如果序列中有一个数，与序列中其他任何一个数大小都不相等，则这个数叫做“异数”。请找出给定数值序列中所有的“异数”.
     */
    public static void problem1() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Temp> arrayList = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            ;
            String[] inputs = input.split("#");
            int n = Integer.valueOf(inputs[0]);
            int m = Integer.valueOf(inputs[1]);
            arrayList.add(new Temp(n, m));
        }
        Collections.sort(arrayList);
        boolean flag = false;
        Map<Temp, Integer> map = new HashMap<>();
        for (int i = 1; i < arrayList.size(); ++i) {
            Temp cur = arrayList.get(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        for (Temp temp : map.keySet()) {
            if (map.get(temp) == 1) {
                System.out.println(temp.n + "#" + temp.m);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("None");
        }
    }

    public void problem2() {
    }

    public void problem3() {
    }

    public void problem4() {
    }

    static class Temp implements Comparable {
        int n;
        int m;
        int value;

        public Temp(int n, int m) {
            this.n = n;
            this.m = m;
            this.value = getValue();
        }

        public int getValue() {
            if (n == 10) {
                return m;
            }
            char[] chars = String.valueOf(m).toCharArray();
            int result = 0;
            for (int i = 0, j = n; i < chars.length; ++i) {
                int temp = ((int) chars[i] - 48) * (int) Math.pow(n, chars.length - i - 1);
                result += temp;
            }
            return result;
        }


        @Override
        public String toString() {
            return "Temp{" +
                    "n=" + n +
                    ", m=" + m +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Temp)) return false;
            Temp temp = (Temp) o;
            return value == temp.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public int compareTo(Object o) {
            Temp temp = (Temp) o;
            return this.value - temp.value;
        }
    }
}