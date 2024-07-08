package org.ex.leetcode.top100.heap.kthlargestelementinastream703;

import java.util.PriorityQueue;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/8 15:34
 */
public class Solution {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest obj = new KthLargest(k, nums);
        int param_1 = obj.add(3);
        // 3
        System.out.println(param_1);
        // 5
        int param_2 = obj.add(5);
        System.out.println(param_2);
        // 10
        int param_3 = obj.add(10);
        System.out.println(param_3);
        // 9
        int param_4 = obj.add(9);
        System.out.println(param_4);
        // 4
        int param_5 = obj.add(4);
        System.out.println(param_5);


    }

}
