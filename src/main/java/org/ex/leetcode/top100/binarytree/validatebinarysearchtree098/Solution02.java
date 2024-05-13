package org.ex.leetcode.top100.binarytree.validatebinarysearchtree098;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/13 14:54
 */
public class Solution02 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);

        if(root.val <= pre) return false;
        pre = root.val;

        boolean right = isValidBST(root.right);
        return left && right;
    }
}
