package org.ex.leetcode.top100.matrix.spiralmatrix054;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: Spiral Matrix
 * @author: Leif
 * @date: 2024/4/10 15:17
 */
public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while(true){
            // 从左到右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if (--right < left) break;
            // 从右到左
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            if (++left > right) break;


        }

        return ans;


    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix).forEach(System.out::print);
    }
}
