package org.ex.leetcode.top100.slidingwindow.minimumsizesubarraysum209;

/**
 * @desc: Minimum Size Subarray Sum
 * @author: Leif
 *
 * 思路 滑动窗口
 * @date: 2024/3/28 10:00
 */
public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, sum = 0;
        int count = Integer.MAX_VALUE;
        while(right < n){
            sum += nums[right];
            // 当sum > target的时候，挪动左指针不断向右缩小窗口，直到sum == target，找出最小窗口，即数组下标区间（count)
            while (sum >= target){
                count = Math.min(count, right - left + 1);
                // 不断从元素和中减少最左侧的元素
                sum -= nums[left];
                // 指针向右移动
                left++;
            }
            right++;
        }
        return count == Integer.MAX_VALUE ? 0 : count;

    }
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
