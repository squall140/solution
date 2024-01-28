package org.ex.leetcode.advancedalgorithm.greedy.nonoverlappingintervals435;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @desc: Non Overlapping Intervals
 *
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 *
 * Example 2:
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 *
 *
 * 思路  贪心算法
 *
 * @author: Leif
 * @date: 2024/1/25 09:47
 */
public class Solution {
    public static int eraseOverlapIntervals(int[][] intervals){
        if (intervals.length == 0) return 0;
        int n = intervals.length;
        int ans = 0;
        // 区间排序，从左到右，左侧端点从小到大
        Arrays.sort(intervals, (o1, o2) -> Long.compare(o1[0],o2[0]));
        // 记录当前区间右端点位置
        int cur_right = intervals[0][1];
        // 遍历
        for (int i = 1; i < n; i++ ){
            // 如果下一个区间的左侧端点大于当前区间的右侧端点，那么视为重叠
            if( intervals[i][0] < cur_right  ){
                // 更新当前右侧节点的位置，取最小值
                cur_right = Math.min(cur_right, intervals[i][1]);
                ans++;
            }else{
                // 如果没有重叠，就不用移除，只需要更新当前右侧端点位置即可
                cur_right = intervals[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = {{1,2},{1,2},{1,2}};
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals(intervals));
    }



}
