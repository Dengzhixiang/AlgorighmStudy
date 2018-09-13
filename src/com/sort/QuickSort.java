package com.sort;

import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {
    /**
     * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     */
    public static void main(String[] args) {
        int[] list = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println("************快速排序************");
        System.out.println("排序前：");
        display(list);
        System.out.println("排序后：");
        quickSort(list, 0, list.length - 1);
        display(list);
    }

    /**
     * 快速排序算法
     */
    public static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);
            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }
    }

    /**
     * 此处假设从小到大排序
     * <p>
     * 分割数组，找到分割点
     */
    public static int partition(int[] data, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = data[left];
        while (left < right) {
            // 先从右往左找到第一个比基准小的数
            while (left < right && data[right] >= first) {
                right--;
            }
//            // 交换
            swap(data, left, right);
            // 再从左往右找到第一个比基准大的数
            while (left < right && data[left] <= first) {
                left++;
            }
            // 交换
            swap(data, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    /**
     * 交换数组中两个位置的元素
     */
    public static void swap(int[] list, int left, int right) {
        int temp;
        if (list != null && list.length > 0) {
            temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }

    /**
     * 遍历打印
     */
    public static void display(int[] list) {
        if (list != null && list.length > 0) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    public static int partitionVersionTwo(int[] A, int start, int end) {
        Random rad = new Random();
        int n = end - start + 1;
        swap(A, end, start + rad.nextInt(n));
        int j = start;
        for (int i = start; i < end; ++i) {
            if (A[i] < A[end]) {
                swap(A, i, j++);
            }
        }
        swap(A, end, j);
        return j;
    }
}