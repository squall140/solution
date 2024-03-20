package org.ex.leetcode.top100.binarytree.levelordertraversal102;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: BFS
 * @author: Leif
 * @date: 2024/3/20 10:05
 */
public class Solution01 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>(){{ offer(root);}};
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            // 获取当前层的节点数量
            int size = queue.size();
            // 遍历当前层，加入结果集
            while (size-- > 0){
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
