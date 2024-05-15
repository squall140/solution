package org.ex.leetcode.top100.binarytree.invertbinarytree226;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Review
 * @author: Leif
 * @date: 2024/5/15 14:06
 */
public class Solution03 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>(){{ offer(root); }};
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
            TreeNode tmp = new TreeNode();
            tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }

        return root;
    }
}
