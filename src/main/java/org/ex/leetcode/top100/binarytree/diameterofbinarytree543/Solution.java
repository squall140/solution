package org.ex.leetcode.top100.binarytree.diameterofbinarytree543;

/**
 * @desc: Diameter of binary tree
 * @author: Leif
 *
 * DFS
 *
 * https://leetcode.cn/problems/diameter-of-binary-tree/solutions/2454405/gong-shui-san-xie-jian-dan-dfs-yun-yong-vbf27/
 *
 * @date: 2024/5/15 14:39
 */
public class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode cur){
        if ( cur == null ) return 0;
        int l = dfs(cur.left), r = dfs(cur.right);
        ans = Math.max(ans, l + r);
        // 单次执行流程中，先递归处理当前节点 cur 的左右节点，得到左右子树为根时的“往下”最大路径 l 和 r，
        // 两者中的较大值 +1 即是本次执行流程的返回值（+1 的含义是在子路径基础上增加当前节点）。
        return Math.max(l, r) + 1;
    }
}
