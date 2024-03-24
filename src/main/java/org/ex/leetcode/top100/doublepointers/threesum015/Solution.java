package org.ex.leetcode.top100.doublepointers.threesum015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: Three Sum
 * Given an integer array nums,
 * return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * @author: Leif
 * @date: 2024/3/24 21:24
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0; i < n; i++){
            // 边界条件
            if (nums[i] > 0) break;
            int l = i + 1;
            int r = n - 1;
            while( l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) continue;
                    while(l < r && nums[r] == nums[r - 1]) continue;
                    l++;
                    r--;
                }else if (sum < 0){
                    l++;
                }else if (sum > 0){
                    r--;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
