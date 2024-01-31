package org.ex.leetcode.set.singlenumber136;

import java.util.HashSet;

/**
 * @desc: Single Number
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 *
 * 思路 贪心
 *
 * @author: Leif
 * @date: 2024/1/31 10:34
 */
public class Solution {
    public static int singleNumber(int[] nums) {
        // 时间复杂度要求O(n)
        // 空间复杂度要求O(1)
        int n = nums.length;
        if (n == 1) return nums[0];

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }

        }
        // 返回第一个元素
        return set.iterator().next();

    }

    public static void main(String[] args) {
        int[]  nums = {1,1,3,3,4,7,8,8,5,4,5};
        System.out.println(singleNumber(nums));
     }


}
