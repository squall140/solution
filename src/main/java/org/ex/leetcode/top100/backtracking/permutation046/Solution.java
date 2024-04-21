package org.ex.leetcode.top100.backtracking.permutation046;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * 思路 DFS回溯
 *
 * 每层都是从0开始搜索而不是startIndex
 * 需要used数组记录path里都放了哪些元素了
 *
 * @author: Leif
 * @date: 2024/4/21 13:46
 */
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    static Deque<Integer> path = new LinkedList<>();
    // used数组记录path中都存放了哪些元素了
    static boolean[] used;
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        // 需要used数组
        used = new boolean[n];
        dfs(nums, n);
        return res;
    }

    private static void dfs(int[] nums, int n) {
        // 判断终止条件
        if (path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < n; i++){
            // 如果在path中没有记录过
            if (!used[i]){
                used[i] = true;
                path.offerLast(nums[i]);
                // 每层都是从0开始搜索而不是startIndex
                dfs(nums, n);
                // 回溯 (取回使用过的元素，并继续遍历其他排列组合）
                path.pollLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

}
