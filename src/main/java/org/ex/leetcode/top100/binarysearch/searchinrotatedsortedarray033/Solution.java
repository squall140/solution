package org.ex.leetcode.top100.binarysearch.searchinrotatedsortedarray033;

/**
 * @desc: Search Rotate Sorted Array
 * @author: Leif
 * @date: 2024/4/4 16:44
 */
public class Solution {
    public static int search(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length;
        while (left <= right){
            int mid = (left + right ) / 2;
            if (nums[mid] == target) {
                // 找到目标值，返回索引
                return mid;
            }
            if(nums[left] < nums[mid]){
                // 左半区间有序
                if(nums[left] <= target && target < nums[mid]){
                    // 目标值落在左半区间，更新右边界
                    right = mid;
                }else{
                    // 否则在右半区间查找
                    left = mid + 1;
                }
            }else{
                // 右半区间内有序
                if (nums[right] < target && target <= nums[right - 1]){
                    // 目标值落入右半区间，更新左边界
                    left = mid + 1;
                }else{
                    // 否则在左半区间内查找
                    right = mid;
                }
            }
        }
        // 没找到
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
