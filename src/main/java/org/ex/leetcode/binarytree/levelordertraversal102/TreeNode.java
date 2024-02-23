package org.ex.leetcode.binarytree.levelordertraversal102;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/2/22 11:20
 */
public class TreeNode {
    Object data;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int data){ this.data = data;}
    TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
