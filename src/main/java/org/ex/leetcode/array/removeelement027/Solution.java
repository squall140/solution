package org.ex.leetcode.array.removeelement027;

/**
 * @desc: Remove Element
 *
 * 题目示例
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,3,0,4]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 *
 * 思路及算法
 * 最优解，因为题目要求不能开辟新的数组空间，同时明确说明可以引用原数组，而且复杂度只能是O(1)，
 * 那么可以直接实用双指针的玩法，分别左右两个指针遍历一次数组，找出剔除相同元素后的新数组的长度。
 *  - right指针在循环中每次和val判断，如果遇到元素和val相等，那么left指针就不累计（视为删除掉了）
 *  - left 指针只有在right遍历元素不等于val的时候进行累加，最后返回新数组的长度
 *
 * 特点：
 * O(1)，一次遍历
 * 由于新数组是由原数组剔除val相同的元素后得到的，那么长度一定小于原数组，可直接引用原数组操作就行。
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/14 10:22
 *
 *
 */
public class Solution {
    //原题中的removeElement方法只需要传递nums和val
    public static int removeElement(int[] nums, int val){
        int left=0;
        int n = nums.length;
        for(int right=0; right < n; right++){
            if (nums[right] != val){
                nums[left] = nums[right];
                left ++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //case2
        int []nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, val);
        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }

}
