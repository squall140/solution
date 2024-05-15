package org.ex.leetcode.top100.backtracking.subsets076;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/15 19:15
 */
public class Ex01 {
    static List<List<Integer>> res = new ArrayList<>();
    static Deque<Integer> path = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(nums,0, n);
        return res;
    }

    private static void dfs(int[] nums, int startIndex, int length){
        res.add(new ArrayList<>(path));
        // 终止条件
        if (startIndex >= length ) return;
        for (int i = startIndex; i < length; i++){
            path.addLast(nums[i]);
            dfs(nums, i + 1, length);
            // 回溯
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(subsets(nums));
    }
}
