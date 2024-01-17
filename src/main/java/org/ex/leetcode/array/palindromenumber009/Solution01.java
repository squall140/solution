package org.ex.leetcode.array.palindromenumber009;

/**
 * @desc: Palindrome Number
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome
 *
 * 思路一，暴力法
 * 直接反转为字符串，最后比较反转后的字符串与原字符串是否相等
 *
 * @author: Leif
 * @date: 2024/1/17 08:43
 */
public class Solution01 {
    public static boolean isPalandrome(int x){
        String reverseString = (new StringBuffer(x+ "").reverse()).toString();
        return reverseString.equals(x + "");
    }

    public static void main(String[] args) {
        int x = 1234567899;
        System.out.println(isPalandrome(x));

    }

}
