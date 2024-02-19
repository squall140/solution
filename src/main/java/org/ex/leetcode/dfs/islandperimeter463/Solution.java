package org.ex.leetcode.dfs.islandperimeter463;

/**
 * @desc: Island Perimeter
 * <p>
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * <p>
 * Example 1:
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * <p>
 * Example 2:
 * Input: grid = [[1]]
 * Output: 4
 * <p>
 * Example 3:
 * Input: grid = [[1,0]]
 * Output: 4
 * <p>
 * 思路 DFS
 * 求岛屿的周长其实有很多种方法，如果用 DFS 遍历来求的话，
 * 有一种很简单的思路：岛屿的周长就是岛屿方格和非岛屿方格相邻的边的数量。
 * 即：每当在 DFS 遍历中，从一个岛屿方格走向一个非岛屿方格，就将周长加 1。
 * @author: Leif
 * @date: 2024/2/19 15:01
 */
public class Solution {
    public static int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;

    }

    private static int dfs(int[][] grid, int row, int col) {
        // 走到了边缘
        if ( row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ) {
            return 1;
        }
        // 走到了湖泊
        if ( grid[row][col] == 0 ) {
            return 1;
        }
        // 走到了已经访问过的
        if ( grid[row][col] == 2 ) {
            return 0;
        }

        grid[row][col] = 2;

        return dfs(grid, row + 1, col)
                + dfs(grid, row - 1, col)
                + dfs(grid, row, col + 1)
                + dfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(grid));
    }
}
