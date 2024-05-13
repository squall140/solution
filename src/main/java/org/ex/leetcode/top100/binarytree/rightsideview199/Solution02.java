package org.ex.leetcode.top100.binarytree.rightsideview199;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/13 15:23
 */
public class Solution02 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null ) return res;
        Deque<TreeNode> queue = new LinkedList<>(){{ offer(root); }};
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                // 最关键的一步，记录每层的最后一个节点（右节点）
                if(size == 0){
                    res.add(cur.val);
                }

            }
        }

        return res;
    }
}
