package org.ex.leetcode.top100.binarytree.kthsmallestelementinbst230;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc: Kth Smallest Element in BST
 *
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * 思路：二叉搜索树，中序遍历结果为升序，要第几个就拿第几个，用栈实现中序遍历，迭代方式进行中序遍历可以减少空间复杂度
 * 时间复杂度O(n) , 空间复杂度 O(n)
 *
 * @author: Leif
 * @date: 2024/3/20 22:17
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历的应用，迭代方式进行中序遍历可以减少空间复杂度，
        // 不需要存储整个中序遍历的结果，只需要计数到第K个元素即可返回
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while ( current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(root);
                // 向左下探
                current = current.left;
            }
            // 从左走到底，逐个弹出最后一个元素，也是最小元素
            current = stack.pop();
            k--;
            if ( k == 0) {
                return current.val;
            }
            // 向右下探
            current = current.right;
        }
        return -1;


    }


}
