package org.ex.leetcode.top100.backtracking.wordsearch079;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/22 14:27
 */
public class Solution {
    static boolean flag = false;
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // 定义二维 visited[] 数组，表示二维字符网格上每个位置字符的使用情况（同一个单元格内的字母不允许被重复使用），
        // 对于一个新的位置 board[i][j] 来说，可以通过递归判断它的 上、下、左、右 位置上的字符是否是 word 字符串中的下一个字符。
        int[][] visited = new int[m][n];

        // 从左上角遍历矩阵中的每个格子
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                dfs(i, j, board, visited, 0, word);
            }
        }
        return flag;
    }

    private static void dfs(int i, int j, char[][] board, int[][] visited, int start, String word) {
        // 终止条件
        if (start == word.length()) {
            flag = true;
            return;
        }

        // 剪枝操作
        // 若传入的当前遍历的字符的位置 i 和 j 超出了网格 board 的范围
        // 或当前 visited[i][j]==1 表示该位置的字符已经被访问过了
        // 或当前位置的字符已经与要搜索的目标字符不一样了，即 board[i][j]!=word.charAt(start)
        // TODO:【上面这行注释话强烈需要看懂，也就是说要求每一步走的都要和word的每个字母对得上】
        // 此时都不需要继续往下执行，需要进行 <剪枝> 操作，直接回溯到上一层即可，即 return
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] == 1 || board[i][j] != word.charAt(start)) return;

        // 标记  就是把当前格子的元素放入到 "路径" 中。
        visited[i][j] = 1;

        dfs(i, j - 1, board, visited, start + 1, word); // 左
        dfs(i, j + 1, board, visited, start + 1, word); // 右
        dfs(i + 1, j, board, visited, start + 1, word); // 下
        dfs(i - 1, j, board, visited, start + 1, word); // 上

        // 撤销标记
        visited[i][j] = 0;

    }


    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E' },
                {'S', 'F', 'C', 'S' },
                {'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }

}
