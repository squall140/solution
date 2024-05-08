package org.ex.leetcode.top100.binarytree.sametree100;

/**
 * @desc: Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * 递归
 * 终止条件与返回值：
 *
 * 1.当两棵树的当前节点都为 null 时返回 true
 * 2.当其中一个为 null 另一个不为 null 时返回 false
 * 3.当两个都不为空但是值不相等时，返回 false
 *
 * 作者：画手大鹏
 * 链接：https://leetcode.cn/problems/same-tree/solutions/12686/hua-jie-suan-fa-100-xiang-tong-de-shu-by-guanpengc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/4/29 16:41
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
