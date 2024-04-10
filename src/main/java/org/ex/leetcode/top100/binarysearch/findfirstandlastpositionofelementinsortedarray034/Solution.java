package org.ex.leetcode.top100.binarysearch.findfirstandlastpositionofelementinsortedarray034;

import java.util.Arrays;

/**
 * @desc: Find First and Last Position of Element in Sorted Array
 * @author: Leif
 * @date: 2024/4/4 16:00
 */
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length, count = 0;
        int left = 0, right = n - 1;
        int start = -1, end = -1; // 初始化左右边界
        while(left <= right){
//            int mid = left + (right - left ) / 2;
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                // 找到目标值，继续向左和向右搜索边界
                start = mid;
                end = mid;
                // 向左搜索
                int leftBound = mid;
                while (leftBound >= 0 && nums[leftBound] == target) {
                    start = leftBound;
                    leftBound--;
                }
                // 向右搜索
                int rightBound = mid;
                while (rightBound < n && nums[rightBound] == target) {
                    end = rightBound;
                    rightBound++;
                }
                return new int[]{start, end};

            }else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return new int[]{start, end};

    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Arrays.stream(searchRange(nums,target)).forEach(System.out::print);
    }
}
