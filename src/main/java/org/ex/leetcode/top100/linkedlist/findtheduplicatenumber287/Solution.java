package org.ex.leetcode.top100.linkedlist.findtheduplicatenumber287;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/11 16:12
 */
public class Solution {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // finding the intersection point of the two pointers
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        // reset slow
        slow = nums[0];

        // finding the entrance of the cycle
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }

    public static void main(String[] args) {
//        int[] nums = {1,3,4,2,2};
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }

}
