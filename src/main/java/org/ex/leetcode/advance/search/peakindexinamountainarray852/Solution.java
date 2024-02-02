package org.ex.leetcode.advance.search.peakindexinamountainarray852;

/**
 * @desc: Peak Index in a Mountain Array
 *
 * An array arr is mountain if the following properties hold:
 * - arr.length >= 3
 * - There exists some i with 0 < i < arr.length - 1 such that:
 *  - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *  - arr[i] > arr[i + 1] > ... > arr[arr.length -1]
 *
 * Given a mountain array arr, return the index i
 * such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 *
 * You must solve it in O(log(arr.length)) time complexity.
 *
 * Example 1:
 * Input: arr = [0,1,0]
 * Output: 1
 *
 * Example 2:
 * Input: arr = [0,2,1,0]
 * Output: 1
 *
 * Example 3:
 * Input: arr = [0,10,5,2]
 * Output: 1
 *
 * 思路 二分
 *
 * 注意题目要求是 to solve it in O(log(arr.length)) time complexity.
 * 题目数据保证 arr 是一个山脉数组
 *
 * @author: Leif
 * @date: 2024/2/2 15:11
 */
public class Solution {
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0,10,20,30,40,100,5,3,2,1};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
