package org.ex.leetcode.top100.binarytree.kthsmallestelementinbst230;

import java.util.*;

/**
 * @desc: Kth Smallest Element in BST
 *
 * 暴力解法
 *
 * 1.先层序遍历把所有元素都存到队列里
 * 2.对队列进行排序，取出最小元素
 *
 * @author: Leif
 * @date: 2024/4/30 10:52
 */
public class Solution02 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null ) return 0;
        Deque<TreeNode> queue = new LinkedList<>(){{ offer(root); }};
        List<Integer> minList = new ArrayList<>();
        while (!queue.isEmpty()){
            // 获取当前层的节点数量
            int size = queue.size();
            while (size-- > 0){
                TreeNode cur = queue.poll();
                minList.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }

        Collections.sort(minList);
        return minList.get(k - 1);

    }
}
