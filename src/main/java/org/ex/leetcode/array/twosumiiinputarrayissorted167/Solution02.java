package org.ex.leetcode.array.twosumiiinputarrayissorted167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Two Sum II - Input Array Is Sorted
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2,
 * added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * <p>
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * <p>
 * 思路 双指针遍历
 *
 * 利用 HashMap 可以通过遍历数组找到数字组合，时间和空间复杂度均为 O(N) 。
 * 注意本题的 numbers 是 排序数组 ，因此可使用 双指针法 将空间复杂度降低至 O(1) 。
 * 时间复杂度 O(N) ： N 为数组 numbers 的长度；双指针共同线性遍历整个数组。
 * 空间复杂度 O(1) ： 变量 left, right 使用常数大小的额外空间。
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/solutions/2361541/167-liang-shu-zhi-he-ii-shu-ru-you-xu-sh-k3oy/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * @author: Leif
 * @date: 2024/1/29 14:29
 */
public class Solution02 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        // 由于已知数组是升序排列
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }

        }
        return new int[0];

    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] arr = twoSum(numbers, target);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
