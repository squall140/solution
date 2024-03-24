package org.ex.leetcode.top100.hash.longestconsecutivesequence128;

import java.util.*;

/**
 * @desc: Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * @author: Leif
 * @date: 2024/3/24 14:24
 */
public class Solution {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        // 1. 遍历所有数组元素装入集合
        for (int x : nums){
            set.add(x);
        }
        // 2. 重新遍历数组，开始和集合中的元素比对
        for (int num : nums){
            // 3.如果set集合中包含比当前元素num还要小1的元素，那么视为num 并不是左边界（连续数组中的最小值）
            if (set.contains(num - 1 )) {
                continue;
            }else{
                int counter = 0;
                // 4.如果当前num为最小左边界值，那么开始尝试递归找出在集合中num++的所有连续元素
                while (set.contains(num++)){
                    counter++;
                }
                // 5.因为数组无限长，所以可能有几段儿不同的连续子数组，那么需要我们找出最长的那段连续序列
                res = Math.max(res, counter);
            }

        }

       return res;

    }
    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
}
