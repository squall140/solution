package org.ex.leetcode.top100.binarytree.rightsideview199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @desc: Binary Tree Right Side View
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * 思路，二叉树右视图，BFS题型，层序遍历，找到每层最后一个节点即可
 * @author: Leif
 * @date: 2024/3/21 08:29
 */
public class Solution01 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>() {{
            offer(root);
        }};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                //这一步很关键，找到每层最后一个元素
                if (size == 0) res.add(node.val);
            }
        }
        return res;
    }
}

