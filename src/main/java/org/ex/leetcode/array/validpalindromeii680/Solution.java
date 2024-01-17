package org.ex.leetcode.array.validpalindromeii680;

/**
 * @desc: Valid Palindrome II
 * Given a string s,
 * return true if the s can be palindrome after deleting at most one character from it.
 *
 * Example 1:
 * Input: s = "aba"
 * Output: true
 *
 * Example 2:
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 *
 * 思路，继续双指针，可容忍一个字母不一样
 *
 * @author: Leif
 * @date: 2024/1/17 15:52
 */
public class Solution {
    public static boolean validPalindrome(String s){
        if (s.isEmpty()) return true;
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                //分两种情况，一是右边减一，二是左边加一
               return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean validPalindrome(String s, int i, int j){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcca";
        System.out.println(validPalindrome(s));
    }



}
