package com.sort;

/**
 * 〈插入排序〉
 *
 * @author Administrator
 * @create 2018/6/29
 * @since 1.0.0
 */
public class Sort {

    /**
     * 共8种排序算法：
     *  内部排序：
     *      插入排序：
     *          直接插入排序
     *          希尔排序
     *      选择排序：
     *          简单选择排序
     *          堆排序
     *      交换排序：
     *          冒泡排序
     *          快速排序
     *      归并排序：
     *      基数排序：
     *
     * 堆排序和归并排序的最好、平均、最坏时间复杂度均为nlogn
     * 只有直接插入排序、归并排序、基数排序、冒泡排序为稳定。
     *
     */

    /**
     * 直接插入排序
     * 时间复杂度：
     * 最好：n
     * 平均：n2
     * 最坏: n2
     * 稳定
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        int length = array.length;
        int i, j, key;

    }

    /**
     * 简单选择排序
     * 时间复杂度：
     * 最好：n2
     * 平均：n2
     * 最坏: n2
     * 不稳定
     *
     * @param array
     */
    public static void selectionSort(int[] array) {

    }


    /**
     * 冒泡排序
     * 时间复杂度：
     * 最好：n
     * 平均：n2
     * 最坏: n2
     * 稳定
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {

    }

    /**
     * 快速排序
     * 时间复杂度：
     * 最好：nlogn
     * 平均：nlogn
     * 最坏: n2
     * 不稳定
     * 空间复杂度：nlogn
     *
     * @param array
     */
    public static void quickSort(int[] array) {

    }


}