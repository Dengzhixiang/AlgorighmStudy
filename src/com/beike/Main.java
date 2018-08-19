package com.beike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 〈贝壳〉
 *
 * @author Administrator
 * @create 2018/8/18
 * @since 1.0.0
 */
public class Main {
//
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] A = new int[n];
//        for (int i = 0; i < n; ++i) {
//            A[i] = in.nextInt();
//        }
//        Arrays.sort(A);
//        int result = 0;
//        if (n % 2 == 1) {
//            result = A[1] + A[3];
//            for (int i = 1; i < n; i += 2) {
//                result += A[i + 1];
//            }
//            System.out.println(result);
//        } else {
//            for (int i = 1; i < n; ++i) {
//                result += A[i];
//            }
//            System.out.println(result);
//        }
//    }

    static class SheTuan implements Comparable{
        int x;
        int y;
        int number;
        SheTuan(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        @Override
        public int compareTo(Object o) {
            SheTuan temp = (SheTuan) o;
            if (x == temp.x) {
                return y - temp.y;
            }
            return x - temp.x;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + number;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<SheTuan> list = new ArrayList<>();
        for (int i = 1; i < n + 1; ++i) {
            list.add(new SheTuan(scanner.nextInt(), scanner.nextInt(), i));
        }
        Collections.sort(list);
        
//        for (int i = 0; i < list.size(); ++i) {
//            System.out.println(list.get(i));
//        }

        // 冲突数量
        int count = 0;

        // 是否毫无冲突
        boolean flag = true;
        SheTuan pre = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            SheTuan temp = list.get(i);
            if (temp.x < pre.y) {
                flag = false;
                count++;
            }
            pre = temp;
        }
        if (flag) {
            System.out.println(n);
            for (int i = 0; i < n; ++i) {
                System.out.print(i + 1);
                if (i != n - 1) {
                    System.out.print(" ");
                }
            }

        }
//         else if (count > 1) {
//            System.out.println(0);
//        }

        int maxCount = 0;
         int index = 0;
        for (int i = 0; i < n; ++i) {
            SheTuan temp1 = list.get(i);
            int temp = 0;
            int temp3 = 0;
            for (int j = i + 1; j < n; ++j) {
                SheTuan temp2 = list.get(j);
                if (temp2.x > temp1.x && temp2.x < temp1.y || temp2.y > temp1.x && temp2.y < temp1.y) {
                    temp++;
                    temp3 = j;
                }
            }
            if (temp > maxCount) {
                maxCount = temp;
                index = temp1.number;
            }
        }
        System.out.println(index);

    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
//
//    }
}