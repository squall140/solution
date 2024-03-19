package org.ex.leetcode.top100.binarytree.invertbinarytree226;

/**
 * @desc: Given the root of a binary tree, invert the tree, and return its root.
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 * 思路：递归
 *
 * 其实就是交换一下左右节点，然后再递归的交换左节点，右节点
 * 根据动画图我们可以总结出递归的两个条件如下：
 * - 终止条件：当前节点为 null 时返回
 * - 交换当前节点的左右节点，再递归的交换当前节点的左节点，递归的交换当前节点的右节点
 * 时间复杂度：每个元素都必须访问一次，所以是 O(n)
 * 空间复杂度：最坏的情况下，需要存放 O(h) 个函数调用(h是树的高度)，所以是 O(h)
 *
 * 作者：王尼玛
 * 链接：https://leetcode.cn/problems/invert-binary-tree/solutions/73159/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/3/19 14:47
 */
public class Solution01 {
    public TreeNode invertTree(TreeNode root) {
        // 写递归一定要先写终止条件
        if (root == null) return null;
        // 将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        // 递归交换当前节点的左子树
        invertTree(root.left);
        // 递归交换当前节点的右子树
        invertTree(root.right);
        return root;


    }
}
