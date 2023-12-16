package org.ex.leetcode.array.removeduplicates080;

/**
 * @desc: Remove Duplicates from Sorted Array II
 *
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 *
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 * 题目说了 最多只能重复两次 我们可以从第三个元素开始看，因为前两个元素 就算是重复，也是有效的，
 * 所以不需要更新 那么当前的值nums[i]只要跟前两个值 nums[count-2] 比较， 如果相同，意思是重复值，
 * 所以不用更新nums[count]的值， 如果不相同，意思是不重复的，所以要更新nums[count]的值，并且count要+1
 *
 * @author: Leif
 * @date: 2023/12/14 14:00
 */
public class Solution_01 {
    public static int removeDuplicates(int[] nums){
        int n = nums.length;
        if(nums.length <= 2) return nums.length;
        int count = 2;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] != nums[count-2]){
                nums[count++]=nums[i];
            }
//            System.out.println(Arrays.toString(nums));
        }
        return count;

    }


    public static void main(String[] args) {
        //case2
        int []nums = new int[]{0,0,1,1,1,1,2,3,3};

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = new Solution_01().removeDuplicates(nums);
//        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

}
