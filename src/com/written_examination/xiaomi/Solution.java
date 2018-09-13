package com.written_examination.xiaomi;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/29 17:13
 */
public class Solution {

    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public static int countBitDiff(int m, int n) {
        // 异或， 相同为0，不同为1
        int result = m ^ n;
        // 计算异或结果有多少个1
        int count = 0;
        //
        while (result > 0) {
            result &= (result - 1);
            count++;
        }
        return count;
    }

    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
        int profit;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countBitDiff(1999, 2299));
    }

}
