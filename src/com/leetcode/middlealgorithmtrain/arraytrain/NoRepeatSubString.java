package com.leetcode.middlealgorithmtrain.arraytrain;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈无重复最长子串〉
 *
 * @author Administrator
 * @create 2018/9/9
 * @since 1.0.0
 */
public class NoRepeatSubString {

    public static void main(String[] args) {
        lengthOfLongestSubstring("1");
    }

    /**
     * 滑动窗口思想：如果确定子串s[i,j]（假设表示字符串的第i个字符到第j-1个字符表示的子串），那么只需要比较s[j]是否与子串s[i,j]重复即可
     * <p>
     * 若重复：记录此时滑动窗口大小，并与最大滑动窗口比较，赋值。然后滑动窗口大小重定义为1，头位置不变，并右移一个单位。
     * <p>
     * 若不重复：滑动窗口头不变，结尾+1，整个窗口加大1个单位。继续比较下一个。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int sum = 0, i = 0, j = 0;
        while (i < chars.length && j < chars.length) {
            if (!set.contains(chars[j])) {
                set.add(chars[j++]);
                sum = Math.max(sum, j - i);
            } else {
                set.remove(chars[i++]);
            }
        }
        return 0;
    }
}