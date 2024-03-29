package org.ex.leetcode.top100.array.mergesortedarray088;

/**
 * @desc:
 *
 * 思路 从后往前合并
 *
 * @author: Leif
 * @date: 2024/3/29 14:01
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        // 合并后的数组长度
        int count = nums1.length;
        // 按照数组数量少的一方nums2长度遍历
        // 从nums1最后一位开始，比较两个数组，谁大就把谁放到合并后的nums1最后一位
        while ( n > 0){
            // 注意这里需要对 m 也进行控制(m > 0)，否则会越界
            if (m > 0 && nums1[m - 1]  > nums2[n - 1]){
                nums1[count - 1] = nums1[m - 1];
                m--;
            }else{
                nums1[count - 1] = nums2[n - 1];
                n--;
            }
            count--;
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
