package com.nubiya;

import java.util.*;

/**
 * 〈努比亚笔试〉
 *
 * @author Administrator
 * @create 2018/9/21
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
//        problem1();
//        problem2();
        problem3();
    }

    public static void problem1() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(",");
        double n = Double.valueOf(inputs[0]);
        int m = Integer.valueOf(inputs[1]);
        double result = n;
        for (int i = 0; i < m - 1; ++i) {
            n /= 2;
            result += 2 * n;
        }
        System.out.println(result);
    }

    public static void problem2() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(",");
        int[] array = new int[inputs.length];
        for (int i = 0; i < inputs.length; ++i) {
            array[i] = Integer.valueOf(inputs[i]);
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; ++i) {
            if (i == 0) {
                System.out.print(array[i]);
            } else {
                System.out.print("," + array[i]);
            }
        }
    }

    public static void problem3() {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        String word = scanner.nextLine();
        int result = 0;
        Set<String> wordss = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < inputs.length; ++i) {
            if (!wordss.contains(inputs[i])) {
                if (inputs[i].contains(word)) {
                    result++;
                    arrayList.add(inputs[i]);
                }
                wordss.add(inputs[i]);
            }
        }
        System.out.println(result);
        Set<String> words = new HashSet<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (!words.contains(arrayList.get(i))) {
                if (i == arrayList.size() - 1) {
                    System.out.print(arrayList.get(i));
                } else {
                    System.out.print(" " + arrayList.get(i));
                }
//                words.add(arrayList.get(i));
            }
        }
    }
}