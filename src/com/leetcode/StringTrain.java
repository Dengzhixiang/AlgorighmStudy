package com.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 〈Leetcode 初级算法训练 -> 字符串训练〉
 *
 * @author Administrator
 * @create 2018/6/22
 * @since 1.0.0
 */
public class StringTrain {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }
        s = s.toLowerCase();
        // 匹配除小写字母和数字的所有字符
        String result = s.replaceAll("[^a-z0-9]", "");
        StringBuilder sb = new StringBuilder(result);
        if (sb.reverse().toString().equals(result)) {
            return true;
        }
        return false;
    }


    // 字符串转整数 (atoi)
    public static int myAtoi(String str) {
        char[] array = str.trim().toCharArray();
        if (array.length == 0) {
            return 0;
        }
        int result = 0;
        boolean isPositive = true;
        boolean sign = true;
        if (array[0] == '-') {
            isPositive = false;
            sign = false;
        } else if (array[0] == '+') {
            sign = false;
        }
        for (int i = (sign ? 0 : 1); i < array.length; ++i) {
            if (Character.isDigit(array[i])) {

                if (result > Integer.MAX_VALUE / 10 || array[i] - '0' > Integer.MAX_VALUE - result * 10) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + (array[i] - '0');
            } else {
                break;
            }
        }
        return isPositive ? result : -result;
    }

    public String reverseString(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        for (int i = 0; i < array.length / 2; ++i) {
            char temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
        return String.valueOf(array);
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return -reverse(-x);
        }
        int sum = 0;
        while (x != 0) {
            // 提前判断 sum = sum * 10 + x % 10 会不会溢出
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return sum;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Integer temp = map.get(s.charAt(i));
            if (temp == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Integer temp = map.get(s.charAt(i));
            if (temp == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            Integer temp = map.get(t.charAt(i));
            if (temp == null) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        for (Character temp : map.keySet()) {
            if (map.get(temp) != 0) {
                return false;
            }
        }
        return true;
    }


    // 数数并说
//    public static String countAndSay(int n) {
//        if (n <= 0) {
//            return null;
//        }
//        if (n == 1) {
//            return "1";
//        }
//        StringBuilder stringBuilder = new StringBuilder("11");
//        // 第n个序列
//        for (int i = 2; i < n; ++i) {
//            StringBuilder temp = new StringBuilder();
//            // 连续个数
//            int count = 1;
//            int j = 1;
//            // 对前一个序列进行推导
//            for (; j < stringBuilder.length(); ++j) {
//                if (stringBuilder.charAt(j) == stringBuilder.charAt(j-1)) {
//                    count++;
//                } else {
//                    temp.append(count).append(stringBuilder.charAt(j-1));
//                    count = 1;
//                }
//            }
//            temp.append(count).append(stringBuilder.charAt(j-1));
//            stringBuilder = temp;
//        }
//        return stringBuilder.toString();
//    }
    // 数数并说
    public static String countAndSay(int n) {
        char[] say = new char[]{'1'};
        for (int i = 1; i < n; i++) {
            say = countAndSay(say);
        }
        return new String(say);
    }

    public static char[] countAndSay(char[] say) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < say.length; i++) {
            if (i == 0) {
                continue;
            }
            if (say[i] == say[i - 1]) {
                count++;
            } else {
                sb.append(count).append(say[i - 1]);
                count = 1;
            }
        }
        sb.append(count).append(say[say.length - 1]);
        return sb.toString().toCharArray();
    }

    // 实现 strStr()
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l2 == 0) {
            return 0;
        } else if (l1 < l2) {
            return -1;
        }
        for (int i = 0; i <= l1 - l2; ++i) {
            if (haystack.substring(i, i + l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // 最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String result = "";
        boolean flag = false;
        for (int i = 0; i < strs[0].length(); i++) {
            int count = 0;
            for (int j = 1; j < strs.length; ++j) {
                if (strs[0].charAt(i) == strs[j].charAt(i)) {
                    count++;
                } else {
                    flag = true;
                    break;
                }
            }
            if (count == strs.length - 1) {
                result += strs[0].charAt(i);
            }
            if (flag) {
                break;
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        Arrays.toString(new int[]{});
//        Arrays.deepHashCode(new int[][]{});
////        String[] array = new String[]{"flower","flow","flight"};
//        String[] array = new String[]{"aca", "cba"};
//        System.out.println(longestCommonPrefix(array));
////        Arrays.sort(array, Comparator.comparingInt(String::length));
////        Arrays.stream(array).forEach(System.out::println);
//
//    }
}
