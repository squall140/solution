package org.ex.leetcode.array.foursum018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: Four Sum
 * <p>
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * 思路 双指针
 * @author: Leif
 * @date: 2024/1/29 13:44
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        // 边界判断
        if (nums.length < 4) return res;
        int len = nums.length;
        // 1. 排序 O(nlogn)
        Arrays.sort(nums);
        // 2. 双指针遍历 (相比三数之和多了一层for循环） O(n^3)
        for (int i = 0; i < len - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue; // 跳过重复
                }
                // 左指针
                int l = j + 1;
                // 右指针
                int r = len - 1;
                while (l < r) {
                    // 计算4数之和，解决整型越界问题
                    // [1000000000,1000000000,1000000000,1000000000] -294967296
                    // 输出： [[1000000000,1000000000,1000000000,1000000000]]
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    // 如果满足条件则加入结果集，同时左去重处理
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 去重
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        // 向中心靠拢
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    }
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));

    }


}
