package com.leetcode;

import java.util.Arrays;

/**
 * 〈Leetcode初级算法训练 -> 排序和搜索〉
 *
 * @author Administrator
 * @create 2018/7/7
 * @since 1.0.0
 */
public class SortAndSearchTrain {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 0, 0, 0, 0};
        int[] nums2 = new int[]{4, 5, 6, 7};
        merge(nums1, 4, nums2, 4);
        Arrays.toString(nums1);
    }

    /**
     * 合并有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        for (; k >= 0; k--) {
            if (i < 0 || j < 0) {
                break;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
        if (i < 0) {
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }

    /**
     * 第一个错误的版本
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int result = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (isBadVersion(middle)) {
                high = middle - 1;
                result = middle;
            } else {
                low = middle + 1;
            }
        }
        return result;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}