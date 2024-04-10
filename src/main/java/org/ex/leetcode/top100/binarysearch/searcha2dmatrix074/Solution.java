package org.ex.leetcode.top100.binarysearch.searcha2dmatrix074;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/10 13:57
 */
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 ) return false;
        // 一共有多少行
        int rows = matrix.length;
        // 一共有多少列
        int cols = matrix[0].length;
        // 行 * 列就是所有元素
        int left = 0, right = rows * cols - 1;

        while (left <= right){
            // 拉直了取中心点
            int mid = left + (right - left) / 2;
            // TODO: 下面这行需要注意
            // 当前元素的列为 mid % cols ，行为 mid / cols
            int value = matrix[mid / cols][mid % cols];
            if(value < target){
                left = mid + 1;
            }else if (value > target) {
                right = mid - 1;
            }else {
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
