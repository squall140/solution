package org.ex.leetcode.set.containsduplicateii219;

import java.util.HashMap;

/**
 * @desc: Contains Duplicate II
 *
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * 思路  哈希表
 *
 * @author: Leif
 * @date: 2024/1/5 09:40
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i =0; i < n; i++){
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <=k ){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

}
