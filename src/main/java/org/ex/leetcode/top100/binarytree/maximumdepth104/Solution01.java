package org.ex.leetcode.top100.binarytree.maximumdepth104;

/**
 * @desc:
 *
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 * 思路：DFS
 * 找出终止条件：当前节点为空
 * 找出返回值：节点为空时说明高度为 0，所以返回 0，节点不为空时则分别求左右子树的高度的最大值，
 * 同时加 1 表示当前节点的高度，返回该数值
 * 某层的执行过程：在返回值部分基本已经描述清楚
 * 时间复杂度：O(n)
 *
 * 作者：画手大鹏
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/10740/hua-jie-suan-fa-104-er-cha-shu-de-zui-da-shen-du-b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/3/19 14:18
 */
public class Solution01 {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


}
