package org.ex.leetcode.array.maxconsecutiveones485;

/**
 * @desc: 快慢指针
 * @author: Leif
 * @date: 2024/3/12 10:58
 */
public class Ex01 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int counter = 0, max = 0;
        for(int i = 0; i < n; i ++) {
            if (nums[i] == 1){
                counter++;
            }else{
                counter = 0 ;
            }
            max = Math.max(max, counter);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println(res);

    }
}
