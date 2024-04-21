package org.ex.leetcode.top100.backtracking.subsets076;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 * @author: Leif
 * @date: 2024/4/21 14:19
 */
public class Solution01 {
    // 结果集
    static List<List<Integer>> res = new ArrayList<>();
    // 搜索路径
    static Deque<Integer> path = new LinkedList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(nums, 0, n);
        return res;
    }

    private static void dfs(int[] nums, int startIndex, int n) {
        // 在新一轮dfs递归之前把当前path的元素加入结果集
        res.add(new ArrayList<>(path));
        // 如果起始搜索点超出数组超度就终止
        if (startIndex >= n) return;

        // 遍历 + 回溯
        for(int i = startIndex; i < n; i ++){
            path.addLast(nums[i]);
            // 这里需要注意 i + 1 是为了回溯的时候元素组合不重复
            dfs(nums, i + 1, n);
            // 回溯
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }


}
