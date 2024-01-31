package org.ex.leetcode.array.rotatearray189;

import java.util.*;

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
 *
 * @author: Leif
 * @date: 2024/1/31 14:28
 */
public class Solution01 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> rotatedStack = new LinkedList<>();
        while ( k > 0){
            rotatedStack.addFirst(nums[ n - 1]);
            n--;
            k--;
        }
        for(int i = 0; i < n; i ++){
            rotatedStack.offer(nums[i]);
        }
        nums = rotatedStack.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
//        int[] nums ={-1,-100,3,99};
//        int k = 2;
        rotate(nums, k);
    }
}
