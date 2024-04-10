package org.ex.leetcode.top100.matrix.setmatrixzeroes073;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc: Set Matrix Zeroes
 * @author: Leif
 * @date: 2024/4/10 14:26
 */
public class Solution {
    public static void setZeroes(int[][] matrix){
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0 ;j < col; j++){
                // 重新遍历，如果有任何一行 或者 任何一列中包含了0
                // 把元素所在行/列的元素赋值为0
                if (row_zero.contains(i) || col_zero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for(int i = 0 ; i < matrix.length; i ++){
            for (int j =0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
