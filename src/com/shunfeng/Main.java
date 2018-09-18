package com.shunfeng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 〈顺丰科技 --> 笔试〉
 *
 * @author Administrator
 * @create 2018/9/15
 * @since 1.0.0
 */
public class Main {


    public static void main(String[] args) {
        problem1();
    }

    /**
     * 最长双节棍字符串
     */
    private static void problem1() {
        Scanner cin = new Scanner(System.in);
        String input = cin.nextLine();
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        // 枚举每三个字母，每次递增一个字母
        for (int l = 0; l + 1 < chars.length; ) {
            int count1 = 1;
            int count2 = 1;
            int count3 = 1;
            int index = 0;
            int i = l;
            // 第一个字母的个数
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                i++;
                count1++;
            }
            // 第二个字母的个数
            int j = i + 1;
            while (j + 1 < chars.length && chars[j] == chars[j + 1]) {
                j++;
                count2++;
            }
            // 第三个字母的个数
            int k = j + 1;
            while (k + 1 < chars.length && chars[k] == chars[k + 1]) {
                k++;
                count3++;
                index = k;
            }
//            System.out.println(count1 + " " + count2 + " " + count3);
            if (count2 < count1) {
                if (count1 <= count3) {
                    System.out.println(new String(chars, l, index + 1));
                } else {
                    System.out.println(new String(chars, l, index));
                }
            }
            l = i + 1;
        }
    }

    /**
     * 单词数组左右对齐
     */
    private static void problem2() {
        Scanner cin = new Scanner(System.in);
        String input = cin.nextLine();
        String maxWidth = cin.nextLine();
        fullJustify(input.split(","), Integer.valueOf(maxWidth));
    }


    public static List<String> fullJustify(String[] words, int maxWidth) {
        return null;
    }
}