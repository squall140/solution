package org.ex.leetcode.advance.greedy.largestnumber179;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @desc: Largest Number
 *
 * Given a list of non-negative integers nums,
 * arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 *
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 * 思路 贪心
 *
 * 算法逻辑实际上是对比相邻的两个字符串的正反拼接后的大小，大的就放前面小的放后面
 * [3,30] => [330,303] => 330
 * [3,34] => [334,343] => 343
 *
 * @author: Leif
 * @date: 2024/2/21 10:38
 */
public class Solution {
    public static String largestNumber(int[] nums) {
//        int n = nums.length;
//        String[] str = new String[n];
//        // 转换为字符串数组
//        for (int i = 0; i < n; i++){
//            str[i] = String.valueOf(nums[i]);
//        }
        String str[] = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        // 开始对比, 从大到小
        Arrays.sort(str,((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        // 如果排序后从0开始，那么直接就是0
        if(str[0].equals("0")) return "0";
        return Arrays.stream(str).collect(Collectors.joining(""));

//        StringBuilder res = new StringBuilder();
//        for (String s : str){
//            res.append(s);
//        }
//        return res.toString();

    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
