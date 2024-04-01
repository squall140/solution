package org.ex.leetcode.top100.linkedlist.reverselinkedlist206;

/**
 * @desc: Reverse Linked List
 *
 * @author: Leif
 * @date: 2024/4/1 21:50
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur.next = tmp;

        }
        return pre;
    }

}
