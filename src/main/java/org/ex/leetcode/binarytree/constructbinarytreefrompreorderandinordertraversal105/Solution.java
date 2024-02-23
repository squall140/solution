package org.ex.leetcode.binarytree.constructbinarytreefrompreorderandinordertraversal105;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * 思路 二叉树构建操作，考察二叉树前序、中序遍历理论知识 （根->左->右，左->根->右）
 * 1. 通过前序遍历的第一个元素确定根节点root
 * 2. 中序遍历数组中，找到root对应的下表 rootIndex，那么rootIndex - 1就是左子树的根节点，rootIndex + 1 是右子树的根节点
 * 3. 递归往返操作，构造rootLeft 和 rootRight，直到结束
 * 4. 通过使用一个Map数组，在首次遍历中序数组的时候，存入元素的位置，方便后续使用的时候直接查O(1)
 *
 * 仔细看官方和k神题解
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2361558/105-cong-qian-xu-yu-zhong-xu-bian-li-xu-4lvkz/
 *
 * @author: Leif
 * @date: 2024/2/22 13:39
 */
public class Solution {
    private static Map<Integer, Integer> indexMap;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            // 遍历中序数组，依次把节点下标提前存入map
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private static TreeNode myBuildTree(int[] preorder, int[] inorder,
                               int preorder_left, int preorder_right,
                               int inorder_left, int inorder_right) {
        // 终止条件
        if (preorder_left > preorder_right) return null;
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历字典中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把当前的根节点创建出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到当前左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder,
                preorder_left + 1, preorder_left + size_left_subtree,
                inorder_left, inorder_root - 1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder,
                preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root + 1, inorder_right);

        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        TreeNode newTree = buildTree(preorder, inorder);
        System.out.println("done");

    }
}
