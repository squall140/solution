package org.ex.leetcode.advance.slidewindow.maximumaveragesubarrayi643;

/**
 * @desc: Maximum Average Subarray I
 * <p>
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value
 * and return this value.
 * Any answer with a calculation error less than 10(-5) will be accepted.
 * <p>
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * <p>
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 * @author: Leif
 * @date: 2024/2/18 19:23
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        // 先计算出当前第一个窗口需要的和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        // 这一步比较关键
        int maxSum = sum;
        // 从第k个元素开始，逐个加一，求出后续所有子数组的和
        for (int j = k; j < n; j++){
            sum = sum - nums[j - k] + nums[j];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 12, -5, -6, 50, 3};
//        int k = 4;
        int[] nums = {4,0,4,3,3};
        int k = 5;
        System.out.println(findMaxAverage(nums, k));
    }
}
