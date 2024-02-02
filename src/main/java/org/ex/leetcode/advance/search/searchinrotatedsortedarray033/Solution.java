package org.ex.leetcode.advance.search.searchinrotatedsortedarray033;

import java.util.Arrays;

/**
 * @desc: Search In Rotated Sorted Array
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 *
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * 思路 二分法 O(logN)
 *
 * 但凡是从有序序列中找某个数，我们第一反应应该是「二分」。
 * 这道题是一个原本有序的数组在某个点上进行了旋转，其实就是将原本一段升序的数组分为了两段。
 * 我们可以先找到旋转点 idx，然后对 idx 前后进行「二分」。
 *
 * 作者：宫水三叶
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/2/1 10:12
 */
public class Solution {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int splitIndex = 0;
        // 这里注意下因为下方判断有i+1，所以这里i必须小于n-1，否则越界
        for (int i = 0; i < n - 1; i++){
            // 如果下一个元素小于当前元素，视为反转分割点
            if(nums[i + 1] < nums[i]) {
                splitIndex = i;
                break;
            }
        }

        int ans = find(nums,target,0,splitIndex);
        if (ans != -1){
            return ans;
        }else if(splitIndex + 1 < n){
            ans = find(nums,target,splitIndex + 1,n - 1);
            return ans;
        }

        return -1;

    }

    public static int find(int[] nums, int target, int left, int right){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(search(nums, target));
    }
}
