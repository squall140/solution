package org.ex.leetcode.top100.binarysearch.searchinsertposition035;

/**
 * @desc: Search Insert Position
 * @author: Leif
 * @date: 2024/4/4 15:54
 */
public class Solution {
    public static int searchInsert(int[] nums, int target){
        int n = nums.length;
        int left = 0 , right = n - 1;
        while(left <= right){
//            int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        // 如果没有搜索到，返回left的位置，即将要插入新元素的下标位置
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
