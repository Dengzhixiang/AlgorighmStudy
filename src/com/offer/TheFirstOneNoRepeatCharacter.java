package com.offer;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */

/**
 * 解题思路：
 * 插入：数组记录每个字符出现的顺序，如多次出现记为-1,未出现过为0，非零为出现的顺序
 * 查找：遍历数组值非-1且最小的值。
 */
public class TheFirstOneNoRepeatCharacter {

    private static int[] array = new int[256];
    private static int index = 1;

    //Insert one char from stringstream
    public static void Insert(char ch) {
        if (array[ch] == 0) {
            array[ch] = index++;
        } else {
            array[ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != 0 && array[i] != -1 && min > array[i]) {
                min = array[i];
                index = i;
            }
        }
        return index == -1 ? '#' : (char) index;
    }

    public static void main(String[] args) {
        Insert('g');
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        Insert('g');
        Insert('l');
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }
}
