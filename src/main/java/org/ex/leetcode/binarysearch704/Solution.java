package org.ex.leetcode.binarysearch704;

/**
 * @desc: 二分查找
 *
 * 把数组每次查找的时候从一半开始找，也称折半查找，要求数组内元素是有序才可以
 * 拆分两个区，取中间值，（1,2,3,4,5）(6,7,8,9)如果大于中间值5，再在右侧区域(6,7,8,9)再次取中间值拆分，递归比较，直至结束
 *
 * 初始条件：left = 0，right = length - 1
 * 终止条件：left > right，即 left == right + 1
 * 向左查找：right = mid - 1
 * 向右查找：left = mid + 1
 *
 * 时间复杂度为O(log n)
 *
 * 第一步：如果集合未排序，则进行排序；
 * 第二步：使用循环或递归在每次比较后将查找空间划分为两半；
 * 第三步：在剩余空间中确定可行的候选者。
 *
 *
 * @author: Leif
 * @date: 2023/8/16 21:49
 */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 等同于 (left + right) / 2，下面的写法可以防止溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 收缩右侧边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 收缩左侧边界
                left = mid + 1;
            }
        }
        return -1;
    }

}
