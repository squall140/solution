package org.ex.leetcode.advance.backtracing.subsets078;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/22 14:07
 */
public class Solution02 {
    static Deque<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(nums, 0, n);
        return res;
    }

    private static void dfs(int[] nums, int startIndex, int length){
        // 搜集path上一次遍历的元素放入结果集
        res.add(new ArrayList<>(path));
        // 终止条件
        if (startIndex >= length) return;

        // 遍历(因为是全排列，所以每次都从0出发）
        for(int i = startIndex ; i < length; i++){
            path.addLast(nums[i]);
            // i + 1 是为了下次回溯到时候，startIndex + 1 也就是不使用重复的元素
            dfs(nums, i + 1, length);
            // 回溯
            path.removeLast();
        }

    }



    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
