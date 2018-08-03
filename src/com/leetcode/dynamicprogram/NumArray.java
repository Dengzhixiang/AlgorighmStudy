package com.leetcode.dynamicprogram;

/**
 * @author dengzx
 * @date 2018/8/1 21:28
 * @description: ${TODO}
 */
public class NumArray {

    /**
     * 303. 区域和检索 - 数组不可变
     *
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     *
     * 示例：
     *
     * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
     *
     * sumRange(0, 2) -> 1
     * sumRange(2, 5) -> -1
     * sumRange(0, 5) -> -3
     * 说明:
     *
     * 你可以假设数组不可变。
     * 会多次调用 sumRange 方法。
     */
    private int[] nums;
    private int[] dp;

    public NumArray(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length + 1];
        init();
    }

    /**
     * 定义:
     *  dp[i][j] 表示 范围 i到j 范围内元素的总和
     *
     */
    private void init() {
        dp[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }

    public static void main(String[] args) {

    }
}
