package org.ex.leetcode.top100.binarytree.symmetrictree101;

/**
 * @desc: Given the root of a binary tree,
 * check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * 思路:递归 DFS
 * 结束条件：
 * 1.都为空指针则返回 true
 * 2.只有一个为空则返回 false
 * 递归过程：
 * 1.判断两个指针当前节点值是否相等
 * 2.判断 A 的右子树与 B 的左子树是否对称
 * 3.判断 A 的左子树与 B 的右子树是否对称
 *
 * @author: Leif
 * @date: 2024/3/19 15:12
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        // 如果两个节点同时为null,那么也视为对称二叉树
        if (L == null && R == null ) return true;
        // 如果只有一个节点为null, 或者节点值不相等,那么直接false
        if (L == null || R == null || L.val != R.val) return false;
        // 判断 L 的左子树与 R 的右子树是否对称 && 判断 L 的右子树与 R 的左子树是否对称
        return recur(L.left, R.right) && recur(L.right, R.left);

    }
}
