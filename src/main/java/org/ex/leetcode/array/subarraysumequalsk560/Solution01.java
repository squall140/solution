package org.ex.leetcode.array.subarraysumequalsk560;

/**
 * @desc: Subarray Sum Equals K
 * <p>
 * Given an array and integers nums and an integer k,
 * return the local number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * 思路，前缀和 简单实现
 *
 * 构建前缀和数组，以快速计算区间和；
 * 注意在计算区间和的时候，下标有偏移。
 *
 * 时间复杂度：O(N^2)，这里 N 是数组的长度；
 * 空间复杂度：O(N)。
 *
 * @author: Leif
 * @date: 2024/1/9 13:32
 */
public class Solution01 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        // 计算前缀和数组
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int ans = 0;
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                if(preSum[right + 1] - preSum[left] == k){
                    ans++;
                }
            }
        }

        return ans;

    }

}
