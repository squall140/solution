package org.ex.leetcode.top100.doublepointers.removeduplicatesfromsortedarrayii080;

import org.ex.leetcode.array.removeduplicates080.Solution_01;

/**
 * @desc: Remove Duplicates From Sorted Array II
 * 思路 双指针
 * @author: Leif
 * @date: 2024/3/29 14:26
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 2;
        if ( n <= k ) return n;
        // fast从第 k 个元素开始，因为前两个元素即便重复也没事儿，那么slow 就在第k -1 的位置
        int fast = k, slow = k - 1;
        while ( fast < n) {
            // 只有当当前元素不等于 slow-k 位置的元素时才进行覆盖
            // nums[fast] != nums[slow - maxRepeat + 1]
            // 保证在区间[0,slow]中元素最多不会超过2次
            if(nums[slow - k + 1] != nums[fast]){
                // 先前进一步
                slow++;
                // 再赋值
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;

    }
    public static void main(String[] args) {
        //case2
        int []nums = new int[]{0,0,1,1,1,1,2,3,3};

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeDuplicates(nums);
//        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
