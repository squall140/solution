package org.ex.leetcode.advance.slidewindow.minimumsizesubarraysum209;

/**
 * @desc: Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 * 思路 双指针，滑动窗口
 * 用右指针确定右端点，不断滑动左指针以满足以下条件：
 * minimal length of a subarray whose sum is greater than or equal to target.
 *
 * 移动右指针，找到和大于 target 的区间，记录当前的区间长度；
 * 尝试从左侧移除元素，如果移除后元素和依旧大于 target，则记录当前区间长度；
 * https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/2642563/hua-dong-chuang-kou-shuang-zhi-zhen-by-t-66iy/
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * @author: Leif
 * @date: 2024/2/18 09:18
 */
public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n <= 1 ) return 0;
        int left = 0, right =0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        // 右指针遍历完所有元素
        while (right < n){
            sum += nums[right];
            // 找到元素和大于 target 的区间，此时 j 正好指向区间右侧元素
            while (sum >= target){
                // 先记录目前的长度，并和上一次进行比较，记录较小值
                ans = Math.min(ans, right - left + 1);
                // 尝试去掉区间最左侧的元素，在下一次循环中判断是否满足条件。
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));

    }



}
