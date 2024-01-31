package org.ex.leetcode.advance.search.binarysearch704;

/**
 * @desc: Binary Search
 *
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * 思路 二分法
 *
 * @author: Leif
 * @date: 2024/1/31 14:13
 */
public class Solution {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        // 细节小于等于
        while (left <= right){
            // 关键在于取中心点这句话的理解
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else
                return mid;

        }
        return -1;

    }

    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
