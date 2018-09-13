package com.sort;

/**
 * 〈归并排序〉
 *
 * @author Administrator
 * @create 2018/7/8
 * @since 1.0.0
 */
public class MergeSort {

    /**
     * 归并排序
     * 时间复杂度：
     * 最好：nlogn
     * 平均：nlogn
     * 最坏: nlogn
     * 不稳定
     * 空间复杂度：n
     *
     * @param array
     * @param left  指向数组第一个元素
     * @param right 指向数组最后一个元素
     */
    public static void mergeSort(int[] array, int left, int right) {
        //如果只有一个元素，那就不用排序了
        if (left == right) {
            return;
        } else {
            //取中间的数，进行拆分
            int middle = (left + right) / 2;
            //左边的数不断进行拆分
            mergeSort(array, left, middle);
            //右边的数不断进行拆分
            mergeSort(array, middle + 1, right);
            //合并
            merge(array, left, middle + 1, right);
        }
    }


    /**
     * 合并数组
     *
     * @param arrays
     * @param left   指向数组第一个元素
     * @param middle 指向数组分隔的元素
     * @param right  指向数组最后的元素
     */
    public static void merge(int[] arrays, int left, int middle, int right) {
        //左边的数组的大小
        int[] leftArray = new int[middle - left];
        //右边的数组大小
        int[] rightArray = new int[right - middle + 1];
        //往这两个数组填充数据
        for (int i = left; i < middle; i++) {
            leftArray[i - left] = arrays[i];
        }
        for (int i = middle; i <= right; i++) {
            rightArray[i - middle] = arrays[i];
        }
        int i = 0, j = 0;
        // arrays数组的第一个元素
        int k = left;
        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {
            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k++] = leftArray[i++];
            } else {
                arrays[k++] = rightArray[j++];
            }
        }
        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k++] = leftArray[i++];
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k++] = rightArray[j++];
        }
    }
}