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
public class Solution01 {
    public static int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 0, right = x / 2;
        while (left < right) {
            // 对着错误的测试用例打印出变量 left 、right 和 mid 的值看一下就很清楚了。
            //mid 不加 1 会造成死循环的代码：
            int mid = left + (right - left + 1) / 2;

            // 调试语句开始
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
            // 调试语句结束

            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;


    }

    public static void main(String[] args) {
        int x = 32;
        System.out.println(mySqrt(x));
    }
}
