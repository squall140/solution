package org.ex.leetcode.top100.binarytree.pathsumiii437;

/**
 * @desc: Path Sum III
 *
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 * 思路 DFS
 * 找到任意节点相加后的和为targetSum的数量
 *
 * https://leetcode.cn/problems/path-sum-iii/solutions/2644522/dfsdi-gui-qian-zhui-he-by-heropie-chocol-0lre/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author: Leif
 * @date: 2024/3/21 22:22
 */
public class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    public void dfs(TreeNode root, int targetSum){
        if (root == null) return;
        if (root.val == targetSum) count++;
        dfs(root.left, targetSum - root.val) ;
        dfs(root.right, targetSum - root.val);
    }
}
