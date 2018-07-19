package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 宝石与石头
 */
public class Problem771 {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String J, String S) {
        int sum = 0;
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < J.length(); ++i) {
            map.put(J.charAt(i), true);
        }
        for (int i = 0; i < S.length(); ++i) {
            Boolean result = map.get(S.charAt(i));
            if (result != null && result) {
                sum++;
            }
        }
        return sum;
    }
}
