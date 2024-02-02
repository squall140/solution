package org.ex.leetcode.advance.search.firstbadversion278;

/**
 * @desc: First Bad Version
 *
 * ou are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 *
 * 思路 二分查找
 *
 * 简单转换下题意，可以理解类似为 在1111000000找出第一个0
 *
 *
 *
 * @author: Leif
 * @date: 2024/2/1 11:49
 */
public class Solution {
    public int firstBadVersion(int n) {
        int left= 0, right = n -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
                // 若 mid 是错误版本，则最后一个正确版本一定在闭区间 [left, mid - 1]
            if(isBadVersion(mid)) {
                right = mid - 1;
               // 若 mid 是正确版本，则首个错误版本一定在闭区间 [mid + 1, right]
            }else{
                left = mid + 1;
            }
        }
        // left 指向首个错误版本，right 指向最后一个正确版本
        return left;

    }

    boolean isBadVersion(int version){
        return true;
    }
}
