package com.offer;

import java.util.Arrays;
import java.util.Random;

/**
 * @author dengzx
 * @date 2018/8/1 19:10
 * @description: ${TODO}
 */
public class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] array = nums.clone();
        Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            int j = random.nextInt(nums.length);
//            System.out.println(j);
            swap(array, i, j);
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

}
