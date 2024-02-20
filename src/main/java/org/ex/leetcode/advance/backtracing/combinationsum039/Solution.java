package org.ex.leetcode.advance.backtracing.combinationsum039;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that
 * sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * 思路 回溯，剪枝算法
 *
 * @author: Leif
 * @date: 2024/2/20 20:54
 */
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    static Deque<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 起始需要剪枝的长度是数组长度
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        dfs(candidates, 0, len, target);
        return res;
    }

    private static void dfs(int[] candidates, int start, int len,  int target) {
        // 路径有问题，同时不会再产生新的节点
        if (target < 0) return;

        // 如果正好剪枝到0，那么证明这条path上的元素之和就等于target
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 这里注意每次要从start开始遍历
        for (int i = start; i < len; i++){
            path.addLast(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len,target - candidates[i]);
            // 把刚入队的元素弹出，回溯
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
