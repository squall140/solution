package org.ex.leetcode.top100.dp.maximumsubarray053;

/**
 * @desc: Maximum Subarray
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * 思路 动态规划
 *  1.定义状态： 设 dp[i] 为以 nums[i] 结尾的连续子数组的最大和
 *  2.状态转移方程： dp[i] = max(dp[i-1] + nums[i], nums[i])，即当前位置的最大和要么是之前的最大和加上当前元素，要么是当前元素本身。
 *  3.初始化： dp[0] = nums[0]，数组的第一个元素作为初始值。
 *  4.遍历： 从数组的第二个元素开始遍历，更新 dp[i]。
 *  5.最终结果： 最大的 dp[i] 即为所求。
 * @author: Leif
 * @date: 2024/3/28 10:33
 */
public class Solution {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        // 1.定义状态： 设 dp[i] 为以 nums[i] 结尾的连续子数组的最大和
        int[] dp  = new int[n];
        // 3. dp[0] = nums[0]，数组的第一个元素作为初始值。
        dp[0] = nums[0];
        // 4. 从数组的第二个元素开始遍历，更新 dp[i]。
        for (int i = 1; i < n; i++){
            // 2.状态转移方程： dp[i] = max(dp[i-1] + nums[i], nums[i])，即当前位置的最大和要么是之前的最大和加上当前元素，要么是当前元素本身。
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 5.最大的 dp[i] 即为所求。
            sum = Math.max(sum, dp[i]);
        }
        return sum;

    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
