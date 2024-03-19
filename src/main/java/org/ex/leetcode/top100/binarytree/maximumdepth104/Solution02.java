package org.ex.leetcode.top100.binarytree.maximumdepth104;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: BFS 广度优先搜索
 *
 * 广度优先搜索的队列里存放的是「当前层的所有节点」
 * 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，
 * 我们需要将队列里的所有节点都拿出来进行拓展，这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，
 * 即我们是一层一层地进行拓展，最后我们用一个变量 ans 来维护拓展的次数，
 * 该二叉树的最大深度即为 ans
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/349250/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/3/19 14:33
 */
public class Solution02 {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        // 创建队列
        Deque<TreeNode> queue = new LinkedList<>();
        // 整棵树先入队
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            // 得到所有节点的总数量
            int size = queue.size();
            // 按层入队
            while (size-- > 0){
                TreeNode curNode = queue.pop();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            // 同时统计入队了多少层
            count++;
        }
        return count;
    }
}
