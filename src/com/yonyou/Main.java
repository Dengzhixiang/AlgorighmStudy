package com.yonyou;

import java.util.*;

/**
 * 〈用友笔试〉
 *
 * @author Administrator
 * @create 2018/9/10
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
//        problem1();
        problem2();
    }

    public static void problem2() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String input = cin.nextLine();
            String[] numString = input.split(" ");
            int[] nums = new int[numString.length];
            for (int i = 0; i < numString.length; ++i) {
                nums[i] = Integer.valueOf(numString[i]);
            }
            Map<Integer, Integer> map = new HashMap<>(numString.length);
            int pre = nums[0];
            int start = nums[0];
            int count = 1;
            map.put(start, count);
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] - pre == 1) {
                    count++;
                } else {
                    map.put(start, count);
                    start = nums[i];
                    count = 0;
                }
                pre = nums[i];
            }
            int max = Integer.MIN_VALUE;
            int maxInteger = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (map.containsKey(nums[i]) && map.get(nums[i]) > max) {
                    max = map.get(nums[i]);
                    maxInteger = nums[i];
                }
            }
            int maxCount = map.get(maxInteger) + 1;
            System.out.println("[" + maxInteger + ", " + maxCount + "]");
        }
    }

    public static void problem1() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String input = cin.nextLine();
            String[] labels = input.split(" ");
            Arrays.sort(labels);
            Set<String> set = new LinkedHashSet<>();
            for (int i = 0; i < labels.length; ++i) {
                // 判断长度是否合法
                int illegal = labels[i].length() % 2;
                // 判断是否有父节点
                String parent = labels[i].substring(0, labels[i].length() - 2);
                if (!set.contains(parent) && labels[i].length() != 2) {
                    illegal = 1;
                }
                // 是否已经输出过
                if (set.contains(labels[i])) {
                    illegal = 1;
                }
                if (illegal == 0) {
                    int sum = labels[i].length() / 2 - 1;
                    for (int j = 0; j < sum; ++j) {
                        System.out.print("\t");
                    }
                    System.out.println(labels[i]);
                }
                set.add(labels[i]);
            }
        }
    }
}