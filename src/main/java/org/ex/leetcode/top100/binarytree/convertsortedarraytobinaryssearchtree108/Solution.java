package org.ex.leetcode.top100.binarytree.convertsortedarraytobinaryssearchtree108;

/**
 * @desc: Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 *
 * 思路： BST 二叉搜索树 利用DFS递归构建树
 * 整体思路参考 https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solutions/2592692/javapython3cfen-zhi-zhong-xu-bian-li-mei-qkzz/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author: Leif
 * @date: 2024/3/20 15:29
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    /**
     * 对范围 [left, right) 的元素生成树
     * 选择数组nums中给定范围的 [left, right) 的中点作为根节点，[left, mid)作为左子树，[mid+1, right]作为右子树
     * @param nums: 元素数组
     * @param left: 左边界
     * @param right: 右边界
     * @return: 构造的根节点
     */
    private TreeNode buildTree(int[] nums, int left, int right) {
        // 首先写明递归终止条件
        if ( left >= right ) return null;
        // 取数组中心点
        int mid = left + (right - left) / 2;
        // 创建根节点并递归生成子树
        return new TreeNode(
                nums[mid],
                buildTree(nums, left, mid),
                buildTree(nums, mid + 1, right));

    }

}
