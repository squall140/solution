package org.ex.leetcode.array.rangesumquery303;

/**
 * @desc: Range Sum query
 *
 * Given an integer array nums, handle multiple queries of the following type:
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 *
 * Implement the NumArray class:
 *      NumArray(int[] nums) Initializes the object with the integer array nums.
 *      int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 *
 *
 * 思路 前缀和算法
 * 公式 sumRange(i,j)=sums[j+1]−sums[i]。
 * 我们可以先创建一个数组，用来存放从原数组每项累加的和，我们称其为前缀和数组。
 *
 * @author: Leif
 * @date: 2024/1/8 14:02
 */
public class NumArray {
    int[] sums;
    public NumArray(int[] nums){
        int n = nums.length;
        // 按照给定的数组，初始化一个新的整形数组，用于存储所有元素的累加和
        sums = new int[n + 1];
        for (int i = 0 ; i < n; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right){
        // 根据公式 sumRange(i,j)=sums[j+1]−sums[i]
        // 求left和right区间和，只需要使用sums数组的减法就可以了
        return  sums[right + 1] - sums[left];

    }
}
