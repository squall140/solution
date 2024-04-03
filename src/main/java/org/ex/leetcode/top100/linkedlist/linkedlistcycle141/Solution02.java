package org.ex.leetcode.top100.linkedlist.linkedlistcycle141;

/**
 * @desc: LinkedList Cycle
 *
 * 追击问题（快慢指针）
 * @author: Leif
 * @date: 2024/4/2 09:24
 */
public class Solution02 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slower = head, faster = head;
        while(faster.next != null && faster.next.next != null){
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower) return true;
        }

        return false;
    }
}
