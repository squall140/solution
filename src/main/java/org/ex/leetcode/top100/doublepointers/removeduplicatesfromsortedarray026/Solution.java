package org.ex.leetcode.top100.doublepointers.removeduplicatesfromsortedarray026;

/**
 * @desc: Remove Duplicates From Sorted Array
 *
 * 思路 双指针
 * @author: Leif
 * @date: 2024/3/29 14:08
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        //0,0,1,1,1,2,2,3,3,4
        int n = nums.length;
        int slow = 0, fast = slow;
        while(fast < n ){
            if(nums[fast] != nums[slow]){
                // [细节]如果不相等，那么slow先前进一步，再进行赋值
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;

    }

    public static void main(String[] args) {
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
