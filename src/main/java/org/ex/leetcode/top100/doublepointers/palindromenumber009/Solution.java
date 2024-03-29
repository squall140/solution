package org.ex.leetcode.top100.doublepointers.palindromenumber009;

/**
 * @desc: Palindrome Number
 *
 * 回文数， 双指针法，两端向中间靠拢
 *
 * @author: Leif
 * @date: 2024/3/29 14:54
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        // 如果长度为0，也可以合法回文
        if (n == 0) return true;
        // 两端向中间靠拢
        int left = 0, right = n - 1;
        while ( left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
