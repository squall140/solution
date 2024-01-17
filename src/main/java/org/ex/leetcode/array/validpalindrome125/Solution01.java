package org.ex.leetcode.array.validpalindrome125;

/**
 * @desc: Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * 思路 暴力 正则 + 字符串反转法
 *
 * @author: Leif
 * @date: 2024/1/17 15:20
 */
public class Solution01 {
    public static boolean isPalindrome(String s){
        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s2 = new StringBuffer(s1).reverse().toString();
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }


}
