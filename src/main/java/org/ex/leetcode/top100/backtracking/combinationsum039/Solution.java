package org.ex.leetcode.top100.backtracking.combinationsum039;

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
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * 在全排列的基础上增加了两数之和
 * 要求返回的组合也是唯一的
 *
 * @author: Leif
 * @date: 2024/4/21 14:49
 */
public class Solution {
    // 结果集
    static List<List<Integer>> res = new ArrayList<>();
    // 路径
    static Deque<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        dfs(candidates, 0, n, target);
        return res;
    }

    private static void dfs(int[] nums, int startIndex, int length, int target){
        // 如果 target < 0 那么path的剪枝路径一定有问题，同时不会再产生新的节点
        if (target < 0) return;

        // 如果 target == 0, 将path路径上所有元素之和一定等于 target
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历
        for (int i = startIndex; i < length; i++){
            path.addLast(nums[i]);
            // 这里要注意i的用意，题目中说可以使用重复的元素，所以才用i，一般用i + 1
            // target - nums[i] 就是每次回溯时候的剪枝操作
            dfs(nums, i, length, target - nums[i]);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

}
