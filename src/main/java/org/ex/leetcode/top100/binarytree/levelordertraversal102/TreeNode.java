package org.ex.leetcode.top100.binarytree.levelordertraversal102;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/20 10:04
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
