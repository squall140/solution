package org.ex.leetcode.top100.doublepointers.movezeroes283;

/**
 * @desc: Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * @author: Leif
 * @date: 2024/3/24 14:55
 */
public class Solution {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        // 快慢指针
        while(fast < n){
            // 遍历数组中不等于0的元素换到左边来(slow)，等于0的换到右边
            if (nums[fast] != 0){
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
            }
            fast++;
        }

    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

    }
}
