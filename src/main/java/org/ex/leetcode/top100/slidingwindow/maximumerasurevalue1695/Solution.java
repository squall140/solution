package org.ex.leetcode.top100.slidingwindow.maximumerasurevalue1695;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @desc: Maximum Erasure Value
 *
 * 题目的简单理解，就是要找到给定数组中不重复的元素所能组成的最大和
 *
 * @author: Leif
 * @date: 2024/3/27 15:53
 */
public class Solution {
    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        // 使用哈希表来做去冲
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int sum = 0, ans = 0;
        // 滑动窗口思路
        while (right < n){
            // 当right指针遍历到重复元素的时候
            while(set.contains(nums[right]) && left <= right){
                // 字典中移除元素
                set.remove(nums[left]);
                // 同时从累计和中减少
                sum -= nums[left];
                // 向左缩小窗口
                left++;
            }
            // [重点，注意下面这行代码的位置]此时将元素加入到hashset，自动去重
            set.add(nums[right]);
            // 累计当前元素和
            sum += nums[right];
            // 求最大
            ans = Math.max(ans, sum);
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums= {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
