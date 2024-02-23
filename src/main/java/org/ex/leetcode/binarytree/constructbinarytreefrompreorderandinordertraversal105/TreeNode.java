package org.ex.leetcode.binarytree.constructbinarytreefrompreorderandinordertraversal105;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/2/23 10:57
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
