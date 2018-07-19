package com.leetcode;

/**
 * 〈Leetcode初级算法 -> 动态规划〉
 *
 * @author Administrator
 * @create 2018/7/7
 * @since 1.0.0
 */
public class DynamicProgrammingTrain {

    private static int[] array = new int[66];

    /**
     * 爬楼梯
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        if (array[n] != 0) {
            return array[n];
        }
        return array[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 买卖股票的最大时机
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int Max = 0;
        if (prices == null || prices.length == 0) {
            return 0;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                Max = Math.max(Max, prices[j] - prices[i]);
            }
        }
        return Max;
    }

    /**
     * 最大子序和
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int current = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (current <= 0) {
                // 若当前值小于0，则抛弃之前的数组和。
                current = nums[i];
            } else {
                // 若当前值大于0，则加上。
                current += nums[i];
            }
            // 取最大值
            maxNum = Math.max(current, maxNum);
        }
        return maxNum;
    }


    /**
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayRecursion(int[] nums) {
        int[][] array = new int[nums.length][];
        array[0] = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            array[0][i] = nums[i];
        }
//        for ()
        return 0;
    }


    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(climbStairs(44));
        System.out.println(maxSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}