package org.ex.leetcode.array.mergesortedarray088;

/**
 * @desc: Merge Sorted Array
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 *  Can you come up with an algorithm that runs in O(m + n) time?
 *
 * @author: Leif
 * @date: 2023/12/15 21:32
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        // m是nums1的长度，n是nums2的长度
        // 要把nums2的元素合并到nums1中，形成新的nums1
        int i = nums1.length;

        //从nums1最后一位开始，比较两个数组，谁大就把谁放到合并后的nums1最后一位
        while (n > 0){
            if( m > 0 && nums1[m - 1] > nums2[n - 1]){
                nums1[i - 1] = nums1[m - 1];
                i--;
                m--;
            }else{
                nums1[i - 1] = nums2[n - 1];
                i--;
                n--;
            }
        }

    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        for(int e : nums1){
            System.out.print(e);
            System.out.print(',');
        }

    }


}
