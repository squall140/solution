package org.ex.leetcode.advance.slidewindow.maximumerasurevalue1695;

import java.util.HashMap;

/**
 * @desc: Maximum Erasure Value
 *
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
 * The score you get by erasing the subarray is equal to the sum of its elements.
 * Return the <b>maximum score</b> you can get by erasing exactly one subarray.
 *
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a,
 * that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 * Example 1:
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 *
 * Example 2:
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 *
 *
 * @author: Leif
 * @date: 2024/2/18 09:49
 */
public class Solution {
    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        // 定义窗口的首端和尾端
        int left = 0, right = 0;
        int ans = 0 , sum = 0;
        // 因为需要去重，因此需要一个哈希表
        HashMap<Integer, Integer> freq = new HashMap<>();
        while (right < n){
            freq.put(nums[right], freq.getOrDefault(nums[right], 0 ) + 1);
            // 如果哈希表中存储了即将加入滑动窗口的元素
            while (freq.get(nums[right]) > 1 && left <= right){
                // 发现了重复字符，那么先把第二次出现的字符对应的val减1
                freq.put(nums[left], freq.get(nums[left]) - 1);
                // 需要不断的把窗口的左边元素移除窗口
                // 元素和需要减去移除的值
                sum -= nums[left];
                left++;
            }
            sum += nums[right];
            // 求当前元素最大和
            ans = Math.max(ans, sum);
            right++;

        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {4,2,4,5,6};
        int[] nums = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }


}
