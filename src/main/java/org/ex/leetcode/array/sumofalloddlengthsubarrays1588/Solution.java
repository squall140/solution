package org.ex.leetcode.array.sumofalloddlengthsubarrays1588;

/**
 * @desc: Sum of All Odd Length SubArrays
 * <p>
 * Given an array of positive integers arr,
 * return the sum of all possible odd-length subarrays of arr.
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,4,2,5,3]
 * Output: 58
 * Explanation: The odd-length subarrays of arr and their sums are:
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * @author: Leif
 * @date: 2024/1/8 14:11
 */
public class Solution {
    public int sumOddLengththeSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            // 前缀和下标从1开始
            // 所有元素的前缀和
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }

        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n ; length +=2){
                // 重新遍历所有奇数下标所构成的子数组之和，也是用到了前缀和
                // 数组 arr 的下标范围 [start,end] 的子数组的和为 prefixSums[end+1]−prefixSums[start]
                int end = start + length - 1;
                // 奇数前缀和
                sum+= prefixSums[end + 1] - prefixSums[start];
            }
        }

        return sum;

    }
}
