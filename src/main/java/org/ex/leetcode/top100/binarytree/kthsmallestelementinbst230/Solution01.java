package org.ex.leetcode.top100.binarytree.kthsmallestelementinbst230;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc: Kth Smallest Element in BST
 *
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * 在二叉搜索树中，任意子节点都满足“左子节点 <<< 根节点 <<< 右子节点”的规则。
 * 因此二叉搜索树具有一个重要性质：二叉搜索树的中序遍历为递增序列。
 * 也就是说，本题可被转化为求中序遍历的第 k 个节点。
 *
 * 思路：二叉搜索树，中序遍历结果为升序，要第几个就拿第几个，用栈实现中序遍历，迭代方式进行中序遍历可以减少空间复杂度
 * 时间复杂度O(n) , 空间复杂度 O(n)
 *
 * @author: Leif
 * @date: 2024/3/20 22:17
 */
public class Solution01 {
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
            // 如果此时k 为 0 ，那么就直接返回当前的元素
            if ( k == 0) {
                return current.val;
            }
            // 因为这里是求第k个最小元素，很有可能k == 2，那么还需要继续向右下探，根据BST的左->根->右 (中序)
            current = current.right;
        }
        return -1;


    }


}
