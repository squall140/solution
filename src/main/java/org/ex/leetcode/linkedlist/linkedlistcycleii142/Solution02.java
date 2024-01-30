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
 * 思路 快慢指针法
 * 看Karl的题解，仔细配套b站配套视频，本题比较经典
 * https://leetcode.cn/problems/linked-list-cycle-ii/solutions/441306/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/
 *
 * @author: Leif
 * @date: 2024/1/30 09:50
 */
public class Solution02 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 遍历条件是快指针计划要走到链表末尾（如果有环的话，那么就一直走下去）
        while (fast != null && fast.next != null){
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;

            // 有环
            if (slow == fast){
                ListNode index1 = fast;
                ListNode index2 = head;
                // 双指针，从头节点和相遇节点，每次各走一步，直到相遇，即入口处的节点
                // 这里具体解法参考题解方程式中的 x == z
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
