package org.ex.leetcode.advance.backtracing.permutations046;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/22 14:14
 */
public class Solution02 {
    static Deque<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static boolean[] visited;
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        dfs(nums,  n);
        return res;
    }

    private static void dfs(int[] nums, int length){
        // 注意这里的终止条件
        if(path.size() == length ){
            // 搜集上一轮的元素到结果集
            res.add(new ArrayList<>(path));
        }

        // 遍历
        for(int i = 0; i < length; i++){
            if(!visited[i]){
                // 标记
                visited[i] = true;
                path.addLast(nums[i]);
                // 因为是全排列，可以重复，所以每次都是从下标第0个元素开始（没有了startIndex的概念）
                dfs(nums, length);
                // 回溯
                path.removeLast();
                // 撤回标记
                visited[i] = false;

            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
