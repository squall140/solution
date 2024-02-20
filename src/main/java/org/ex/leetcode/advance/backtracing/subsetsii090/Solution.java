package org.ex.leetcode.advance.backtracing.subsetsii090;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @desc: Subsets II
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 *  Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * 思路 回溯
 *
 * @author: Leif
 * @date: 2024/2/20 23:11
 */
public class Solution {
    static Set<List<Integer>> res = new HashSet<>();
    static Deque<Integer> path = new LinkedList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        // 由于答案中不能包含相同的方案，因此我们可以先对原数组进行排序，
        // 从而确保所有爆搜出来的方案，都具有单调性，然后配合 Set 进行去重。
        Arrays.sort(nums);
        dfs(nums, 0, n);
        return new ArrayList<>(res);
    }

    private static void dfs(int[] nums, int start, int n) {
        res.add(new ArrayList<>(path));
        // 终止条件
        if (start >= n) return;
        // 遍历
        for (int i = start; i < n; i++){
            path.addLast(nums[i]);
            // i + 1 不重复组合
            dfs(nums, i + 1, n);
            // 回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }


}
