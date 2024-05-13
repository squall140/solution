package org.ex.leetcode.top100.binarytree.maximumdepth104;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/13 15:08
 */
public class Solution03 {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        // 先将树的头节点先入队
        Deque<TreeNode> queue = new LinkedList<>(){{ offer(root); }};
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            depth++;
        }
        return depth;

    }
}
