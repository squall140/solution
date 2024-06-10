package org.ex.leetcode.top100.sort.mergesort;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/6/7 16:00
 */
public class MergeSort {
    private static void mergeSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 核心方法，将两个已排序的数组合并成一个大的
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right){
        // 创建新的临时数组
        int[] temp = new int[right - left + 1];
        // 第一个数组起点
        int i = left;
        // 第二个数组起点
        int j = mid + 1;
        // 临时数组指针
        int k = 0;

        // 比较两个数组，把较小的数组元素放入临时数组
        while(i <= mid && j <= right){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // 若第一个数组没遍历完，还有剩下的元素，那么直接放入新数组尾部
        while (i <= mid){
            temp[k++] = arr[i++];
        }

        // 若第二个数组没遍历完，同样操作
        while (j <= right){
            temp[k++] = arr[j++];
        }

        //将排序后的临时数组元素依次放回原数组
        for(i = 0; i < k; i++){
            arr[left + i] = temp[i];
        }

    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8, 90, 1, 50};
        mergeSort(arr);
        for(int x : arr){
            System.out.print(x + ", ");
        }
    }
}
