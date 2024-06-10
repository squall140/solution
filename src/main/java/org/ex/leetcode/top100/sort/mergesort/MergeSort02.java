package org.ex.leetcode.top100.sort.mergesort;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/6/7 16:32
 */
public class MergeSort02 {
    public static void mergeSort(int[] arr){
        if ( arr == null || arr.length == 0) return;
        sort(arr, 0, arr.length -1);
    }

    public static void sort(int[] arr, int left, int right){
        if (left >= right ) return;
        // 找到中间索引
        int mid = left + (right - left) / 2;
        // 对左边子数组进行递归排序
        sort(arr, 0, mid);
        // 对右边子数组进行递归排序
        sort(arr, mid + 1, right);
        // 合并两个排序好的子数组
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        // 创建临时数组
        int[] temp = new int[right - left + 1];
        // 第一个数组的起始点
        int i = left;
        // 第二个数组的起始点
        int j = mid + 1;
        // 临时数组的指针
        int k = 0;

        // 依次比较两个数组的元素，把较小的放入临时数组中
        while(i <= mid && j <= right ){
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        // 如果第一个数组还有结余，直接填充临时数组尾部
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // 如果第二个数组还有结余，一样操作
        while(j <= right){
            temp[k++] = arr[j++];
        }

        // 都填充以后，把临时数组的元素重新放回原数组中
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
