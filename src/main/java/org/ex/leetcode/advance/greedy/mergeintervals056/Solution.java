package org.ex.leetcode.advance.greedy.mergeintervals056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @desc: Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * 思路 贪心算法
 *
 * @author: Leif
 * @date: 2024/2/19 21:23
 */
public class Solution {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        // 区间排序，从左到右，左侧端点从小到大
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 初始化第一个区间，并声明start,end
        int start = intervals[0][0], end = intervals[0][1];
        // 从第二个区间开始遍历
        for (int i = 1; i < n; i++ ){
            // 如果下一个区间的左边界小于当前节点的右边界，那么视为区间重叠
            if (intervals[i][0] <= end){
                // 如果当前区间左边界小于或者等于上一个区间的右边界，那么视为重合
                // 求出两个重叠区间的最大右边界
                end = Math.max(end, intervals[i][1]);
            }else{
                // 如果当前区间左边界大于上一个区间的右边界，那么一定不重合
                res.add(new int[]{start, end});
                // 更新下当前的左右边界
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 遍历结束后，把当前的左右边界构成的区间也加入结果集
        res.add(new int[]{start, end});
        // 这里是需要返回二维数组，所以要写成new int[0][]
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        Arrays.stream(merge(intervals)).forEach(System.out::println);
        Arrays.stream(merge(intervals)).map((int[] line)
                        -> Arrays.stream(line)
                        .boxed()
                        .collect(Collectors.toList()))
                        .forEach(System.out::println);

    }
}
