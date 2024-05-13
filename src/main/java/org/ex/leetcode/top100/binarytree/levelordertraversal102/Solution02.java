package org.ex.leetcode.top100.binarytree.levelordertraversal102;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: Review
 * @author: Leif
 * @date: 2024/5/13 14:35
 */
public class Solution02 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>(){{ offer(root); }};

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while(size-- > 0 ){
                TreeNode cur = queue.poll();
                tmp.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
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
