package org.ex.leetcode.top100.backtracking.subsets076;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: Subsets
 *
 * 组合要唯一
 *
 * @author: Leif
 * @date: 2024/4/21 14:31
 */
public class Solution02 {
    // 结果集
    static List<List<Integer>> res = new ArrayList<>();
    // 搜索路径
    static Deque<Integer> path = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(nums, 0, n);
        return res;
    }

    private static void dfs(int[] nums, int startIndex, int length){
        // 先讲上一轮的遍历结果添加到结果集中
        res.add(new ArrayList<>(path));
        // 终止条件
        if (startIndex >= length) return;

        // 遍历
        for (int i = startIndex; i < length; i++){
            path.addLast(nums[i]);
            // 这里的 i + 1 实际上就是 startIndex 前进，为了避开相同的元素组合
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
