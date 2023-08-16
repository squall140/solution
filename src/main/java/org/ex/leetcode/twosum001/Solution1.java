package org.ex.leetcode.twosum001;

/**
 * @desc: 001-Two Sum
 * 两种解法，
 *  第一种暴力实现
 *  双数组遍历，时间复杂度 O(n2), 空间复杂度 O(1)
 *
 *
 * @author: Leif
 * @date: 2023/8/4 22:16
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target){
        int len = nums.length;
        for (int i = 0; i < len - 1 ; i++) {
            for (int j = i + 1; j < len; j++) {
                if ( nums[i] + nums[j] == target ){
                    return new int[]{i, j};
                }
            }
            
        }

        //otherwise
        throw new IllegalArgumentException("I can't make it!");

    }
}
