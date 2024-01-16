package org.ex.leetcode.array.longestwellperforminginterval1124;

/**
 * @desc: Longest Well-Performing Interval
 * <p>
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 * Return the length of the longest well-performing interval.
 * <p>
 * Example 1:
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 * <p>
 * Example 2:
 * Input: hours = [6,6,6]
 * Output: 0
 * <p>
 * 思路 前缀和 数组遍历
 * 具体看B站收藏的一个JS的解法
 *
 *
 * @author: Leif
 * @date: 2024/1/16 10:01
 */
public class Solution {

    /**
     * Example 1:
     * <p>
     * Input: hours = [9,9,6,0,6,6,9]
     * Output: 3
     * Explanation: The longest well-performing interval is [9,9,6].
     */
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int ans = 0;

        // 前缀和数组第一个（最左侧）元素是0， 所以长度要比原数组多一个
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;

        // 遍历数组，简化问题，把大于8的元素设置为1（视为良好的工作时间段），其他的设置为-1
        for (int i = 0; i < n; i++) {
            // 这里的prefixSum[i+1]指的是跳过第一个元素0，从下标为1的元素开始
            prefixSum[i + 1] = prefixSum[i] + (hours[i] > 8 ? 1 : -1);

            // 计算简化后数组的前缀和，逐个遍历计算子数组 j -> i 区间的前缀和，这里j在i的左侧
            for (int j = 0; j <= i; j++) {
                int sum = prefixSum[i + 1] - prefixSum[j];
                // 如果发现当前子数组区间前缀和sum > 0，那么则视为此时间段儿是良好的工作时间
                if (sum > 0) ans = Math.max(ans, i - j + 1);
            }

        }

        return ans;
    }
}
