package org.ex.leetcode.linkedlist.addtwonumbers002;

/**
 * @desc: review
 * @author: Leif
 * @date: 2024/5/11 11:40
 */
public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            if (l1 != null) carry += l1.val;
            if (l2 != null) carry += l2.val;

            cur.next = new ListNode(carry % 10);
            cur = cur.next;

            carry = carry / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        return dummy.next;
    }
}
