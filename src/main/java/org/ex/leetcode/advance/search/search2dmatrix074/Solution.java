package org.ex.leetcode.advance.search.search2dmatrix074;

/**
 * @desc: Search 2D Matrix
 *
 * You are given an m x n integer matrix  with the following two properties:
 * - Each row is sorted in non-decreasing order.
 * - The first integer of each row is greater than the last integer of the previous row.
 *
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example1:
 * <img src = "https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" />
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * 思路
 *
 * 因为以上2个条件，所以起始这个二维矩阵就是个有序的数列，
 * 题目中明显要求要把time complexity 控制在 O(logN)级别，
 * 那么索性把二维数组拉直了，用二分法
 *
 * @author: Leif
 * @date: 2024/2/2 09:49
 */
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        // 定义行的长度，一共有几行
        int row = matrix.length;
        // 定义列的长度，实际上就是每一列中有几个元素
        int col = matrix[0].length;
        // 那么行 * 列 就是二维矩阵中的所有元素
        int left = 0, right = row * col - 1;

        while (left <= right){
            int mid = left + (right - left ) / 2;
            // 得到当前元素的行和列的具体坐标
            // mid / col 是在第几行， mid % col 是在第几列
            int value = matrix[mid / col][mid % col];
            if(value < target){
                left = mid + 1;
            }else if(value > target){
                right = mid - 1;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }


}
