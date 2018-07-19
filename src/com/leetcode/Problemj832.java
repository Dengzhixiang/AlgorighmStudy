package com.leetcode;

import java.util.Arrays;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/21
 * @since 1.0.0
 */
public class Problemj832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] B = new int[A.length][A.length];
        for (int i = 0; i < A.length; ++i) { //每一行
            for (int j = 0; j < A[i].length; ++j) {
                B[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        for (int i = 0; i < B.length; ++i) { //每一行
            int num = B[i].length;
            for (int j = 0; j < num / 2; ++j) { //每一列
                B[i][j] = B[i][num-j-1];
            }
        }
        return B;
    }



}