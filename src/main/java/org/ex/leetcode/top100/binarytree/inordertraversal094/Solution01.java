package org.ex.leetcode.top100.binarytree.inordertraversal094;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: Given the root of a binary tree,
 * return the inorder traversal of its nodes' values.
 *
 * 思路：递归，按照访问左子树—>根节点—>右子树
 * 其实就是dfs回溯算法
 *
 * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
 * 空间复杂度：O(n)，空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
 *
 * @author: Leif
 * @date: 2024/3/19 10:50
 */
public class Solution01 {
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        /**
         * 递归调用 inorder(root.left) 来遍历 root 节点的左子树，
         * 然后将 root 节点的值加入答案，
         * 再递归调用inorder(root.right) 来遍历 root 节点的右子树即可，
         * 递归终止的条件为碰到空节点。
         */
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


}
