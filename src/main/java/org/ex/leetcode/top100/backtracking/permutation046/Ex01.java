package org.ex.leetcode.top100.backtracking.permutation046;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/15 19:21
 */
public class Ex01 {

    static boolean[] visited;
    static Deque<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        dfs(nums, n);
        return res;
    }

    private static void dfs(int[] nums, int length){
        if (path.size() == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < length; i++){
            if(!visited[i]){
                visited[i] = true;
                path.addLast(nums[i]);
                dfs(nums,length);
                path.removeLast();
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
