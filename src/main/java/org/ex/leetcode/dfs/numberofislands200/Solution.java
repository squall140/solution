package org.ex.leetcode.dfs.numberofislands200;

/**
 * @desc: Number Of Islands
 * <p>
 * Given an (m x n) 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * Output: 3
 * <p>
 * 思路 DFS 深度优先
 * @author: Leif
 * @date: 2024/2/19 11:09
 */
public class Solution {
    static int m, n;

    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历二位矩阵如果发现有一块儿陆地的话，那么再进行dfs
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    public static void dfs(char[][] grid, int row, int col) {
        // 明确搜索终止条件
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') return;
        // 标记当前岛屿为0
        grid[row][col] = '0';
        //上下左右搜索
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));

    }
}
