package com.leetcode.primary.other;

import java.util.Arrays;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/29 15:32
 */
public class MisssingNumber {

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (Integer temp : nums) {
            sum += temp;
        }
        return n * (n + 1) / 2 - sum;
    }

    public static int missingNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            result ^= (i + 1) ^ nums[i];
        }
        return result;
    }

    static int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber3(new int[]{3, 0, 1}));
    }
}
