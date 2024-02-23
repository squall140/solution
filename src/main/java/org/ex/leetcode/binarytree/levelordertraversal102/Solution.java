package org.ex.leetcode.binarytree.levelordertraversal102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @desc: Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * 思路 二叉树的层序遍历 -> BFS
 * 时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
 * 空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间。
 *
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/solutions/2361604/102-er-cha-shu-de-ceng-xu-bian-li-yan-du-dyf7/
 *
 * @author: Leif
 * @date: 2024/2/22 11:18
 */
public class Solution {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null) queue.add(root);
        while(!queue.isEmpty()){
            // tmp 存储当前层的数据
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                //  将 node.data 添加至 tmp 尾部
                if (node.data != null) tmp.add((Integer) node.data);
                // 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue 。
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // 将当前层结果 tmp 添加入 res
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nodes = {3,9,20,null,null,15,7};
        int n = nodes.length;
        TreeNode newTree = TreeBuilder.arrayToBTree(nodes);
        System.out.println( levelOrder(newTree));
    }

}






