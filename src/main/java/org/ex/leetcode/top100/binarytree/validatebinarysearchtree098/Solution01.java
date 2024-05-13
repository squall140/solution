package org.ex.leetcode.top100.binarytree.validatebinarysearchtree098;

/**
 * @desc: Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 *
 * 题目
 * 验证二叉搜索树
 *
 * 思路
 * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，
 * 如果大于，说明满足 BST，继续遍历；否则直接返回 false。
 * https://leetcode.cn/problems/validate-binary-search-tree/solutions/232885/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author: Leif
 * @date: 2024/3/20 21:20
 */
public class Solution01 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 结束条件：如果root为null，返回true。
        // 因为空的二叉搜索树也是符合条件的
        if ( root == null) return true;
        // 中序遍历：左 -> 根 -> 右
        // 访问左子树
        boolean left = isValidBST(root.left);
        // 访问当前节点，如果当前节点[小于等于]中序遍历的前一个节点，说明不满足BST
        if (root.val <= pre) {
            return false;
        }
        // 如果当前节点[大于]中序遍历上一个值，证明符合条件，更新pre为当前值，继续判断下一个值
        pre = root.val;
        boolean right = isValidBST(root.right);
        // 左右子树都是二叉搜索树，则返回true，否则返回false
        return left && right;
    }
}
