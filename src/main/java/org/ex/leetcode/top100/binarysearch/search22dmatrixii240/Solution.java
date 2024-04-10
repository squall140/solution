package org.ex.leetcode.top100.binarysearch.search22dmatrixii240;

/**
 * @desc: Search a 2D Matrix II
 *
 * @author: Leif
 * @date: 2024/4/10 14:52
 */
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ) return false;
        int rows = matrix.length, cols = matrix[0].length;
        for(int[] row : matrix){
            int index = binarySearch(row, target);
            if (index != -1) return true;
        }
        return false;
    }

    private static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] matrix ={
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }
}

