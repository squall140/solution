package org.ex.leetcode.array.rotatearray189;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Rotate Array
 *
 * Given an integer array nums, rotate the array to the right by k steps,
 * where k is non-negative.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * 思路 反转数组(看动画)
 *
 * 1.首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
 * 2.这时候，从 kkk 处分隔数组，左右两数组，各自进行翻转即可。
 *
 * https://leetcode.cn/problems/rotate-array/solutions/683855/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
 *
 * @author: Leif
 * @date: 2024/1/31 14:28
 */
public class Solution02 {
    public static void rotate(int[] nums, int k) {
        // 如果k很大，超过了n，令k=k % nums.length, 这样k就小于数组中元素的个数，排除重复旋转
        k = k % nums.length;
        // 首次全部反转
        reverse(nums, 0 , nums.length - 1);
        // 以第k个位置为中心，反转 k 左边的数组
        reverse(nums, 0, k - 1);
        // 以第k个位置为中心，反转 k 右边的数组
        reverse(nums, k, nums.length - 1);

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
//        int[] nums ={-1,-100,3,99};
//        int k = 2;
        rotate(nums, k);
    }
}
