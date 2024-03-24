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
        List<List<Integer>> res = new ArrayList<>();
        if ( n < 3) return res;
        // 先排序，很重要
        Arrays.sort(nums);

        for (int i = 0; i < n; i++){
            // 第一个元素都大于0，那么三数之和必定大于0
            if ( nums[i] > 0 ) break;
            // 去重
            if (i> 0 && nums[i] == nums[i - 1]) continue;
            // 双指针
            int l = i + 1;
            int r = n - 1;
            while ( l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    // 排除条件，去重，当 i 不变时，如果此时的 l 值和后一个数值相同，则 l 右移
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    // 反之亦然
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    // 移动双指针
                    l++;
                    r--;

                }else if(sum < 0){
                    // 小于0的时候左指针右移
                    l++;
                }else if(sum > 0){
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
