package org.ex.leetcode.dfs.maxareaofisland695;

/**
 * @desc: Max Area Of Island
 *
 * You are given an m x n binary matrix grid.
 * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 * Example 1:
 * Input: grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 * Input: grid = {{0,0,0,0,0,0,0,0}}
 * Output: 0
 *
 * @author: Leif
 * @date: 2024/2/19 14:37
 */
public class Solution {
    static int rows, cols;
    public static int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (grid[i][j] == 1){
                    // 不断通过dfs寻找累加岛屿面积，求出最大岛屿面积（数量）
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] grid, int row, int col){
        // 边界判断
        if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) return 0;
        // 标记岛屿
        grid[row][col] = 0;
        // 定义面积和
        int sum = 1;
        // 四周扩散
        sum += dfs(grid, row + 1, col);
        sum += dfs(grid, row - 1, col);
        sum += dfs(grid, row, col + 1);
        sum += dfs(grid, row, col - 1);

        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}
