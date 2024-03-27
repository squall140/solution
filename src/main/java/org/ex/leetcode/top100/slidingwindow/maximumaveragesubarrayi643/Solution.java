package org.ex.leetcode.top100.slidingwindow.maximumaveragesubarrayi643;

/**
 * @desc: Maximum Average Subarray
 * <p>
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * @author: Leif
 * @date: 2024/3/27 21:43
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int start = 0, end = 0;
        // 注意下，为什么这里要把res设置为 Integer.MIN_VALUE 而不是 0，要考虑到负数计算
        double res = Integer.MIN_VALUE;
        double sum = 0;
        while(end < nums.length){
            sum += nums[end];
            if (end - start + 1 == k) {
                // 因为这里 sum / k 有可能是 -1 / 1 = -1 ，如果此时的res 是0的话，那么最大值就为0了，影响负数计算
                res = Math.max(res, sum / k);
                sum -= nums[start++];
            }
            end++;
        }
        return res;


    }

    public static void main(String[] args) {
//        int[] nums = {1,12,-5,-6,50,3};
//        int k = 4;
        int[] nums = {-1};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }
}
