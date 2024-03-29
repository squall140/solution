package org.ex.leetcode.top100.doublepointers.removeelement027;

import java.util.Arrays;

/**
 * @desc: Remove Element
 * @author: Leif
 * @date: 2024/3/29 21:08
 */
public class Solution {
    public static int removeElement(int[] nums, int val) {
        // 0,1,2,2,3,0,4,2
        int n = nums.length;
        int slow = 0, fast = slow;
        // 快慢指针
        while (fast < n){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums ={0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        Arrays.stream(nums).forEach(System.out::print);
    }
}
