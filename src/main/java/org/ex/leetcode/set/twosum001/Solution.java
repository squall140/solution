package org.ex.leetcode.set.twosum001;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @desc: Two Sum
 * <p>
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * 思路 哈希表
 * @author: Leif
 * @date: 2024/1/4 21:51
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = null;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(n - 1);

        for (int i = 0; i < n; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) ){
                // 获取当前下标和哈希表中的下标，一起塞入结果数组
                ans = new int[]{i, map.get(another)};
            }
            // 这里注意val保存下标，key对应数组元素
            map.put(nums[i],i);
        }

        return ans;



    }
}
