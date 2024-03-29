package org.ex.leetcode.top100.array.rotatearray189;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @desc: Rotate Array
 *
 * 思路 三次反转
 * 1.首次全部反转
 * 2.以第k个位置为中心，反转 k 左边的数组
 * 3.以第k个位置为中心，反转 k 右边的数组
 *
 * @author: Leif
 * @date: 2024/3/28 15:03
 */
public class Solution {
    public static void rotate(int[] nums, int k) {
        // 如果 k > n 那么切分数组的时候就需要用 k % n
        int n = nums.length;
        k = k % n;
        // 首次全部反转
        reverse(nums, 0, n - 1);
        // 以第k个位置为中心，反转 k 左边的数组
        reverse(nums, 0, k - 1);
        // 以第k个位置为中心，反转 k 右边的数组
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
