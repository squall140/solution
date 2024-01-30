package org.ex.leetcode.linkedlist.linkedlistcycleii142;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc: LinkedList Cycle II
 *
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null;
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote
 * the index of the node that tail's next pointer is connected to (0-indexed).
 *
 * It is -1 if there is no cycle.
 * Note that is not passed as a parameter.
 *
 * Do not modify the linked list.
 *
 * <p>
*  Example 1:
 * <br />
 * <img src = "https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" />
 * <br />
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in t
 *
 * </p>
 *
 * 思路 哈希表
 *
 * 一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；
 * 一旦遇到了此前遍历过的节点，就可以判定链表中存在环。
 * 借助哈希表可以很方便地实现。
 *
 * 复杂度分析
 * 时间复杂度：O(N)，其中 N 为链表中节点的数目。我们恰好需要访问链表中的每一个节点。
 * 空间复杂度：O(N)，其中 N 为链表中节点的数目。我们需要将链表中的每个节点都保存在哈希表当中。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/linked-list-cycle-ii/solutions/441131/huan-xing-lian-biao-ii-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/30 09:50
 */
public class Solution01 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
            ListNode pos = head;
            Set<ListNode> visited = new HashSet<>();
            // 我们遍历链表中的每个节点，并将它记录下来
            while (pos != null){
                // 一旦遇到了此前遍历过的节点，就可以判定链表中存在环
                if(visited.contains(pos)) return pos;
            visited.add(pos);
            pos = pos.next;
        }
        return null;
    }
}
