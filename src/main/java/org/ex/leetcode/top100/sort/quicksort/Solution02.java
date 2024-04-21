package org.ex.leetcode.top100.sort.quicksort;

import java.util.Arrays;

/**
 * @desc: 快排第二版（容易理解）
 * @author: Leif
 * @date: 2024/4/19 16:39
 */
public class Solution02 {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void quickSort(int[] nums, int L, int R) {
        // 终止条件
        if (L >= R) return;

        int left = L;
        int right = R;

        // 随意取一个值作为 pivot ，这里为了方便就取左侧第一个元素 left
        int pivot = nums[left];

        while(left < right){
            // 从右往左找一个比 pivot 小的数
            while (left < right && pivot <= nums[right]) right--;
            // 找到之后把它放到左边
            nums[left] = nums[right];
            // 从左到右找一个比 pivot 大的数
            while (left < right && pivot >= nums[left]) left++;
            // 找到之后把它放到右边
            nums[right] = nums[left];
        }

        // 循环结束时，left == right ，直接把 pivot 放到这个位置
        nums[left] = pivot;

        // 递归操作
        quickSort(nums, L, left - 1);
        quickSort(nums, left + 1, R);

    }
    public static void main(String[] args) {
        int arr[] = {4, 7, 6, 5, 3, 2, 8, 1};
//        int arr[] = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
}
