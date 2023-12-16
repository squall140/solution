package org.ex.leetcode.array.removeduplicates026;

/**
 * @desc: Remove Duplicates from Sorted Array
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 * 复杂度分析：
 *
 * 时间复杂度：O(n)O(n)O(n)。
 * 空间复杂度：O(1)O(1)O(1)。
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/14 11:02
 */
public class Solution {
    //原题中的removeElement方法只需要传递nums和val
    public static int removeDuplicates(int[] nums){
        //因为数组去重操作，所以新数组的长度肯定是小于原数组的
        //那么可以直接引用原数组生成新数组
        //尝试双指针，效率较高
        int n = nums.length;
        int left = 0;

        for (int right = 1; right < n; right ++){
            // {0,0,1,1,1,2,2,3,3,4}
            // 如果左右指针对应的元素不相等，那么把当前的右指针下标的元素赋值给左指针，同时左指针++
            if (nums[right] != nums[left]){
                nums[left+1] = nums[right];
                left ++ ;
            }
        }
        // 因为数组下标是0开始的，所以要+1才是转换后数组中的元素个数
        return left + 1;

    }

    public static void main(String[] args) {
        //case2
        int []nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeDuplicates(nums);
        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }

}
