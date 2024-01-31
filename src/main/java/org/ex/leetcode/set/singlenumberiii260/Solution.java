package org.ex.leetcode.set.singlenumberiii260;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Single Number III
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 *
 * Example 2:
 * Input: nums = [-1,0]
 * Output: [-1,0]
 *
 * Example 3:
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 * 思路 哈希表
 *
 *
 * @author: Leif
 * @date: 2024/1/31 11:16
 */
public class Solution {
    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1){
                ans[i] = num;
                i++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        Arrays.stream(singleNumber(nums)).forEach(System.out::println);

    }
}
