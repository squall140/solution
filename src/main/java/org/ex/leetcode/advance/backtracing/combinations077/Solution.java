package org.ex.leetcode.advance.backtracing.combinations077;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: Combinations
 *
 * Given two integers n and k,
 * return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 *
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 * 思路 回溯
 *
 * 找到k个长度的组合，核心思想就是当搜索路径path的数量恰好等于k的时候，收割结果（终止）
 *
 * @author: Leif
 * @date: 2024/2/21 17:27
 */
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    static Deque<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        dfs(nums, 0, n, k);
        return res;
    }

    private static void dfs(int[] nums, int start, int n, int k) {
        // 终止条件
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历
        for (int i = start; i < n; i++){
            path.addLast(nums[i]);
            dfs(nums, i + 1, n, k);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }


}
