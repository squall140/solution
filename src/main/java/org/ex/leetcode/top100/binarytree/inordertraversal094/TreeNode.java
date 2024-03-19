package org.ex.leetcode.top100.binarytree.inordertraversal094;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/19 10:47
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
