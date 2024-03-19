package org.ex.leetcode.top100.binarytree.maximumdepth104;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/19 14:17
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
