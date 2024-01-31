package org.ex.leetcode.set.singlenumberii137;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Single Number II
 *
 * Given an integer array nums where every element appears three times except for one,
 * which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 * 思路，哈希表 统计出现字符
 *
 * @author: Leif
 * @date: 2024/1/31 10:47
 */
public class Solution {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        if (n == 1) return nums[0];

        for (int num : nums ){
            // 统计每个字符出现次数，存入map, O(n)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        // 遍历map O(n)
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }
}
