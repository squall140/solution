package org.ex.leetcode.advance.backtracing.permutationsii047;

import java.util.*;

/**
 * @desc: Permutations II
 *
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 思路，回溯
 *
 * 唯一和上一题46题的区别是要求结果集中不能有重复的
 * 那么在结果集做去重操作就ok了
 *
 * @author: Leif
 * @date: 2024/2/21 15:10
 */
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    static Deque<Integer> path = new LinkedList<>();
    // used数组记录path里都放了哪些元素了
    static boolean[] used;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        // 需要used数组
        used = new boolean[n];
        // 而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，
        // 然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
        // 因为需要剪枝，需要排序
        Arrays.sort(nums);
        dfs(nums, n);
        return res;
//        return res.stream().distinct().toList();
    }

    private static void dfs(int[] nums, int n) {
        // 判断终止条件
        if (path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }

        // 开始遍历
        for (int i = 0; i < n; i++){
            // 而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，
            // 然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
            // 剪枝操作（去重）
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }

            // 如果没在path中记录过
            if (!used[i]){
                used[i] = true;
                path.addLast(nums[i]);
                // 每层都是从0开始搜索而不是startIndex
                dfs(nums, n);
                // 回溯
                path.removeLast();
                used[i] = false;
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

}
