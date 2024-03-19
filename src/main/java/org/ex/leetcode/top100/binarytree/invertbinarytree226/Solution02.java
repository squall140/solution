package org.ex.leetcode.top100.binarytree.invertbinarytree226;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: 反转二叉树
 * <p>
 * 思路: BFS (迭代 + 队列)
 * <p>
 * 通过队列来记录层级, 每一层的节点进行互换( node 的左 / 右子节点)
 *
 * 算法流程： 看动画
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode.cn/problems/invert-binary-tree/solutions/2361621/226-fan-zhuan-er-cha-shu-fen-zhi-qing-xi-tqlf/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: Leif
 * @date: 2024/3/19 14:59
 */
public class Solution02 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>() {{
            // 整棵树先入队
            offer(root);
        }};
        // 通过队列来记录层级节点, 每一层的节点进行互换
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            // 交换当前节点
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;

    }
}
