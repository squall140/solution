package org.ex.leetcode.set.majorityelement169;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Majority Element
 *
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * 思路， 哈希表
 *
 * @author: Leif
 * @date: 2024/1/31 11:31
 */
public class Solution {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        for (int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : freq.entrySet()){
            int num = entry.getKey(), occ = entry.getValue();
            if (occ > n / 2){
                ans = num;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
}
