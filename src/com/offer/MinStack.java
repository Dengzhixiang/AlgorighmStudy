package com.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dengzx
 * @date 2018/8/1 19:20
 * @description: ${TODO}
 */
public class MinStack {

    private Node sortHead;

    private Node head;

    static class Node {
        Node next;
        int value;

        public Node(int x) {
            this.value = x;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        head = new Node(-1);
        sortHead = new Node(-1);
    }

    public void push(int x) {
        Node temp = new Node(x);
        head.next = temp;
    }

    public void pop() {

    }

    public int top() {
        return head.next.value;
    }

    public int getMin() {
        return sortHead.next.value;
    }

    public boolean isPowerOfThree(int n) {
        if (Math.log10(n) / Math.log10(3) % 1 == 0) {
            return true;
        }
        return false;
    }

    public static List<String> fizzBuzz(int n) {
        List<String> array = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                array.add("FizzBuzz");
            } else if (i % 3 == 0) {
                array.add("Fizz");
            } else if (i % 5 == 0) {
                array.add("Buzz");
            } else {
                array.add(i + "");
            }
        }
        return array;
    }


    /**
     * 颠倒二进制位
     * 颠倒给定的 32 位无符号整数的二进制位。
     * 通过右移n依次获取n的末位 设置为m的末位，左移m实现颠倒
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int m = 0;
        for (int i = 0; i < 32; ++i) {
            m <<= 1; // m左移一位
            m = m | (n & 1); // m的末位设置为n的末位
            n >>= 1;// n右移1位
        }
        return m;
    }

    /**
     * 计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     * 质数筛法
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;
        int[] array = new int[n + 1];
        for (int i = 2; i < n; ++i) {
            if (array[i] == 0) {
                for (int j = i + i; j < n; j += i) {
                    array[j] = 1;
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 位1的个数
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        char[] array = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); ++i) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[') {
                array[index++] = temp;
            } else {
                if (index - 1 < 0) {
                    return false;
                }
                if (array[index - 1] == '(' && s.charAt(i) == ')'
                        || array[index - 1] == '{' && s.charAt(i) == '}'
                        || array[index - 1] == '[' && s.charAt(i) == ']') {
                    index--;
                } else {
                    return false;
                }
            }
        }
        return index == 0;
    }

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
