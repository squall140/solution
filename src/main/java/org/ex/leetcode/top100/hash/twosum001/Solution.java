package org.ex.leetcode.top100.hash.twosum001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Two Sum
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * @author: Leif
 * @date: 2024/3/24 13:30
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dic = new HashMap<>();
        int[] ans = null;
        for(int i = 0; i < n; i++){
            int another = target - nums[i];
            if (dic.containsKey(another)){
                // 获取当前下标和哈希表中的下标，一起塞入结果数组
                ans = new int[]{i, dic.get(another)};
            }
            // 这里注意val保存下标，key对应数组元素
            dic.put(nums[i], i);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Arrays.stream(twoSum(nums,target)).forEach(System.out::println);
    }
}
