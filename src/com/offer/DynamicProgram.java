package com.offer;

/**
 * @author dengzx
 * @date 2018/8/1 18:51
 * @description: ${TODO}
 */
public class DynamicProgram {



    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    /**
     * dp[i]表示到i位置时不相邻数能形成的最大和
     * 递推公式dp[i] = max(num[i] + dp[i - 2], dp[i - 1])
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }


}
