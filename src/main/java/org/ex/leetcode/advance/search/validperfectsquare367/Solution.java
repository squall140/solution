package org.ex.leetcode.advance.search.validperfectsquare367;

/**
 * @desc: Valid Perfect Square
 *
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 *
 * A perfect square is an integer that is the square of an integer.
 * In other words, it is the product of some integer with itself.
 *
 * You must not use any built-in library function, such as sqrt.
 *
 * Example 1:
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 *
 * Example 2:
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 *
 * 思路 二分查找
 *
 *
 * @author: Leif
 * @date: 2024/2/2 08:43
 */
public class Solution {
    public static boolean isPerfectSquare(int num){
        // 1 <= x <= num , num / x == x
        // 特殊值判断
        if (num == 0 || num == 1) {
            return true;
        }

        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int num = 81;
        System.out.println(isPerfectSquare(num));
    }
}
