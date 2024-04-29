package org.ex.leetcode.top100.binarytree.balancedbinarytree110;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/29 16:26
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root){
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }
}
