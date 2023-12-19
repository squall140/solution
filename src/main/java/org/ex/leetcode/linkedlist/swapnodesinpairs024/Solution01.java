package org.ex.leetcode.linkedlist.swapnodesinpairs024;

/**
 * @desc: 两两交换链表中的节点
 *
 * 思路一、递归（标准写法）
 *
 *
 * @author: Leif
 * @date: 2023/12/18 14:42
 */
public class Solution01 {
    public ListNode swapPairs(ListNode head){
        if (head == null) return null;

        // 新链表中的头节点，即原链表的第二节点
        ListNode newHead = head.next;
        // 交换
        newHead.next = head;
        // 原链表头节点的next，指向了新链表头节点的next
        head.next = swapPairs(newHead.next);
        return newHead;

    }
}
