package com.leetcode.middlealgorithmtrain.arraytrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author dengzx
 * @date 2018/8/4 15:04
 * @description: ${TODO}
 */
public class TheSumOfThreeNum {


    /**
     * 三数之和
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                if (nums[low] + nums[high] + nums[i] == 0) {
                    if (!hashSet.contains(Arrays.asList(nums[i], nums[low], nums[high]))) {
                        hashSet.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    }

                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    low++;
                    high--;
                } else if (nums[low] + nums[high] + nums[i] > 0) {
                    high--;
                } else {
                    low++;
                }

            }
        }

        return result;

    }
}