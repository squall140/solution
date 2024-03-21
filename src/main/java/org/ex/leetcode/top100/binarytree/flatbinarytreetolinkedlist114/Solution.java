package org.ex.leetcode.top100.binarytree.flatbinarytreetolinkedlist114;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc: Flatten Binary Tree to LinkedList
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * @author: Leif
 * @date: 2024/3/21 08:39
 */
public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        // 遍历时注意顺序，根左右
        while (!stack.isEmpty()){
            while(root != null){
                list.add(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        int size = list.size();
        for (int i = 1; i < size; i++){
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }
}
