package org.ex.leetcode.array.twosumiiinputarrayissorted167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Two Sum II - Input Array Is Sorted
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2,
 * added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 *
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 *
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 *
 *  Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 *
 * 思路 遍历 + 哈希表
 * 利用 HashMap 可以通过遍历数组找到数字组合，时间和空间复杂度均为 O(N) 。
 *
 * @author: Leif
 * @date: 2024/1/29 14:29
 */
public class Solution01 {
    public static int[] twoSum(int[] numbers, int target){
        int len = numbers.length;
        // 初始化哈希表，k 数值，v 索引
        Map<Integer,Integer> map = new HashMap<>();
        // 结果集，由于只是2个元素，所以长度为2
        int[] ans = new int[2];
        for (int i = 0 ;i < len; i++){
            if (map.containsKey(target - numbers[i]) ){
                ans[0]= map.get(target - numbers[i]) + 1;
                ans[1]= i + 1;
                break;
            }
            map.put(numbers[i], i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] arr = twoSum(numbers,target);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
