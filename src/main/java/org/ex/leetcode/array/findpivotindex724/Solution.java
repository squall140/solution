package org.ex.leetcode.array.findpivotindex724;

import java.util.Arrays;

/**
 * @desc: Find Pivot Index
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers
 * strictly to the left of the index is equal to the sum of all the numbers
 * strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 *
 *
 * @author: Leif
 * @date: 2024/1/8 14:37
 */
public class Solution {
    public int pivotIndex(int[] nums){
        int n = nums.length;
        int lsum =0, rsum=0;
        rsum = Arrays.stream(nums).sum();
        for(int i = 0; i < n; i++){
            rsum -= nums[i];
            if(rsum == lsum) return i;
            lsum += nums[i];
        }
        return -1;
    }
}
