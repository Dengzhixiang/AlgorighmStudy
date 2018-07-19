package com.leetcode;

import java.util.*;

/**
 * 〈Leetcode 初级算法 -> 数组训练〉
 *
 * @author Administrator
 * @create 2018/6/22
 * @since 1.0.0
 */
public class ArrayTrain {

//    public static void main(String[] args) {
//        int[] array = new int[]{1,2,3,4,5,6,7};
//        int[] array = new int[]{9, 9, 9};
//        rotate(array, 2);
//        array = plusOne(array);
//        for (int i : array) {
//            System.out.println(i);
//        }
//        int[] array = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int len = removeDuplicates(array);
//        for (int i = 0; i < len; ++i) {
//            System.out.println(array[i]);
//        }
//        System.out.println(maxProfit(new int[]{7, 6, 5, 4, 3, 1}));
//    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 0; i + 1 < nums.length; ++i) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }
        return index;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] > 9) {
                result[i + 1] = digits[i] - 10;
                result[i] += 1;
            } else {
                result[i + 1] += digits[i];
            }
        }
        for (int i = result.length - 1; i >= 1; --i) {
            if (result[i] > 9) {
                result[i] = result[i] - 10;
                result[i - 1] += 1;
            }
        }
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }

    public static void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; ++j) {
                    if (nums[j + 1] != 0) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((int) '0');
//        String test ;
        char[] chars = new char[]{'1'};
        System.out.println(String.valueOf(chars));
        System.out.println(new char[]{'1', '2'});
//        test.toCharArray()
    }

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Boolean isExist = map.get(nums[i]);
            if (isExist == null) {
                map.put(nums[i], true);
            } else {
                return true;
            }
        }
        return false;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            Integer value = map.get(num);
            map.put(num, (value == null ? 0 : value) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) != 0) {
                temp.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] result = new int[temp.size()];
        int index = 0;
        for (int num : temp) {
            result[index++] = num;
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp > target) {
                j--;
            } else if (temp < target) {
                i++;
            } else {
                result[0] = i;
                result[1] = j;
                break;
            }
        }
        return result;
    }

    /**
     * 数组旋转
     * 首先以从对角线为轴翻转，然后再以x轴中线上下翻转即可得到结果
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][len - i - 1];
                matrix[len - j - 1][len - i - 1] = temp;
            }
        }
        for (int i = 0; i < matrix.length / 2; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        for (int i = 0; i < length; ++i) {
            int[] array1 = new int[10];
            for (int j = 0; j < length; ++j) {
                if (board[i][j] != '.') {
                    if (array1[board[i][j] - 48] != 0) {
                        return false;
                    }
                    array1[board[i][j] - 48]++;
                }
            }
            int[] array2 = new int[10];
            for (int j = 0; j < length; ++j) {
                if (board[j][i] != '.') {
                    if (array2[board[j][i] - 48] != 0) {
                        return false;
                    }
                    array2[board[j][i] - 48]++;
                }
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int[] array1 = new int[10];
                for (int k = 0 + i * 3; k < i * 3 + 3; k++) {
                    for (int l = 0 + j * 3; l < j * 3 + 3; l++) {
                        if (board[k][l] != '.') {
                            if (array1[board[k][l] - 48] != 0) {
                                return false;
                            }
                            array1[board[k][l] - 48]++;
                        }
                    }
                }
            }
        }
        return true;
    }
}