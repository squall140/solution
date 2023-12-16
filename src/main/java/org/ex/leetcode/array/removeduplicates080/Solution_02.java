package org.ex.leetcode.array.removeduplicates080;

/**
 * @desc:
 *
 * 快慢指针思路
 *
 * 通过移动快指针 fast 来找到新的元素，然后将新元素复制到慢指针 slow 的位置，从而在原地删除重复项。
 *
 *
 * @author: Leif
 * @date: 2023/12/14 21:14
 */
public class Solution_02 {
    public int removeDuplicates(int[] nums){
        if (nums.length < 2 || nums == null) return 0;
        int n = nums.length;
        // 每个元素最多出现的个数，由于原数组有序，所以完全可以跳过前两个元素，直接从第三个开始遍历
        int k = 2;
        int slow = k, fast = k;

        // [0,0,1,1,1,1,2,3,3] , nums[fast] = nums[slow] = 1 , nums[slow -k] = 0
        //


        while(fast < nums.length){
            // 如果 nums[fast] 不等于 nums[slow - k]
            // 将 nums[fast] 直接赋值给 nums[slow]，并将慢指针slow向右（向后）移动一位
            if (nums[fast] != nums[slow -k]){
                nums[slow] = nums[fast];
                slow++;
            }
            // 快指针向右（向后）移动一位
            fast++;
        }

        return slow;

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
