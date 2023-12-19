package org.ex.leetcode.array.movezeroes283;

/**
 * @desc: Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * 最优解
 * 一次遍历
 * 这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点 x，然后把所有小于等于 x 的元素放到 x 的左边，大于 x 的元素放到其右边。
 * 这里我们可以用 0 当做这个中间点，把不等于 0(注意题目没说不能有负数)的放到中间点的左边，等于 0 的放到其右边。
 * 这的中间点就是 0 本身，所以实现起来比快速排序简单很多，我们使用两个指针 i 和 j，只要 nums[i]!=0，我们就交换 nums[i] 和 nums[j]
 *
 *
 * @author: Leif
 * @date: 2023/12/15 15:45
 */
public class Solution {
    public static void moveZeroes(int[] nums){
        if (nums == null) return;
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++){
            //当前元素!=0，就把其交换到左边，等于0的交换到右边 (冒泡排序）
            //nums[i]中存储不等于0的值（左侧），nums[j]中存储等于0的（右侧）
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }

        }
    }


    public static void main(String[] args) {
        int[] given_num = new int[]{0,1,0,3,12};
        moveZeroes(given_num);
//        Arrays.stream(given_num).forEach(
//                number -> {
//                    System.out.println(number);
//                }
//        );

        for (Integer num : given_num){
            System.out.println(num);
        }



    }

}
