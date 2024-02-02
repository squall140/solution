package org.ex.leetcode.advance.search.sqrtx069;

/**
 * @desc: Sqrt(x)
 *
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 * 思路
 *
 * 求一个非负整数数的平方根，可以这么理解
 * 找到一个数，这个数满足 0 < x < 0 ，x * x = n ，不难想到区间内是有序的
 * 那么就在这个区间里用二分法查找
 *
 *
 * @author: Leif
 * @date: 2024/2/1 12:19
 */
public class Solution02 {
    public static int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if(square < x){
                left = mid + 1;
            }else if(square > x){
                right = mid - 1;
            }else{
                ans = mid;
                break;
            }

        }
        return ans;


    }

    public static void main(String[] args) {
        int x = 64;
        System.out.println(mySqrt(x));
    }
}
