package org.ex.leetcode.top100.binarytree.inordertraversal094;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: 二叉树中序遍历
 *
 * 思路：使用辅助栈，迭代遍历法，是利用栈先进后出的特性，遍历 左 -> 中 -> 右
 * 看下面题解的动画
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/412886/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author: Leif
 * @date: 2024/3/19 11:31
 */
public class Solution02 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
