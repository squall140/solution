package org.ex.leetcode.array.maxconsecutiveones485;

/**
 * @desc: Max Consecutive Ones
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 * 方法一：一次遍历
 * 为了得到数组中最大连续 1 的个数，需要遍历数组，并记录最大的连续 1 的个数和当前的连续 1 的个数。
 * 如果当前元素是 1，则将当前的连续 1 的个数加 1，否则，使用之前的连续 1 的个数更新最大的连续 1 的个数，并将当前的连续 111 的个数清零。
 * 遍历数组结束之后，需要再次使用当前的连续 1 的个数更新最大的连续 1 的个数，
 * 因为数组的最后一个元素可能是 1，且最长连续 1 的子数组可能出现在数组的末尾，如果遍历数组结束之后不更新最大的连续 1 的个数，则会导致结果错误。
 *
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/15 16:23
 */
public class Solution {
    public static int findMaxConsecutiveOnes(int[] nums){
        int n = nums.length;
        int maxCount = 0, count =0;
        for(int i = 0; i < n; i ++){
            if (nums[i] == 1) {
                count ++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        //遍历完成后，需要再次更新最大连续1的个数，因为数组最后一个元素(n)可能也是1
        maxCount = Math.max(maxCount, count);
        return maxCount;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println(res);

    }





}
