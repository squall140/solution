package org.ex.leetcode.top100.sort.quicksort;

import java.util.Arrays;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/11 16:57
 */
public class Solution01 {
    public static void quickSort(int arr[], int startIndex, int endIndex) {
        //递归结束条件为startIndex大于或等于endIndex
        if (startIndex >= endIndex) {
            return;
        }

        //得到基准元素位置
        int pIndex = partition(arr, startIndex, endIndex);

        //根据基准元素分两部分进行递归排序
        quickSort(arr, startIndex, pIndex - 1);
        quickSort(arr, pIndex + 1, endIndex);
    }

    /*
     * 分治法（双边循环法）
     * arr  待排序数组
     * startIndex  起始下标
     * endIndex  结束下标
     * */
    public static int partition(int arr[], int startIndex, int endIndex) {
        int p = arr[startIndex];//基准元素(可取随机位置)
        int l = startIndex;//左指针
        int r = endIndex;//右指针

        while (l != r) {
            // 控制右指针向左移动，找到比pivot小的那个数
            while ((l < r) && (p < arr[r] )) {
                r--;
            }
            // 控制左指针向右移动，找到大于pivot的那个数
            while ((l < r) && (p >= arr[l] )) {
                l++;
            }
            // 交换l指针和r指针所指的元素
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }

        //交换基准元素和重合点的元素
        arr[startIndex] = arr[l];
        arr[l] = p;
        return l;
    }

    public static void main(String[] args) {
        int arr[] = {4, 7, 6, 5, 3, 2, 8, 1};
//        int arr[] = {2, 0, 2, 1, 1, 0};
        quickSort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}