package org.ex.leetcode.advance.backtracing.subsets078;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: SubSets
 *
 * Given an integer array nums of unique elements, return all possible subsets(the power set).
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * 思路 回溯 求全排列（不重复）
 *
 * @author: Leif
 * @date: 2024/2/20 21:49
 */
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    static Deque<Integer> path = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(nums, 0, n);
        return res;
    }

    private static void dfs(int[] nums, int start, int n) {
        // 在新一轮dfs递归之前把当前path的元素加入结果集
        res.add(new ArrayList<>(path));
        // 如果起始搜索点超出数组长度自动终止
        if (start >= n ) return;
        // 遍历 + 回溯
        for (int i = start; i < n; i++){
            path.addLast(nums[i]);
            // 这里需要注意 i + 1 是为了进行回溯的时候元素组合不重复
            dfs(nums, i + 1, n);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
