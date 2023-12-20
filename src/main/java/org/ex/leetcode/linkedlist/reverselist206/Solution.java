package org.ex.leetcode.linkedlist.reverselist206;

/**
 * @desc: 206 ReverseList 反转链表
 *
 *  迭代解法
 *  1 -> 2 -> 3 -> 4 -> null
 *  null <- 1 <- 2 <- 3 <- 4
 *
 * @author: Leif
 * @date: 2023/8/10 20:52
 */
public class Solution {
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while (current != null ){
            // 临时保存current节点指向的下一个节点
            ListNode temp = current.next;
            // current指针反向 指向前指针
            current.next = prev;
            // prev -> current  前指针后移
            prev = current;
            // 向右移动到temp节点位置进行下一次循环
            current = temp;
        }

        //循环到链表尾部 null的时候终止，完全反转后，最开始的prev成为了最后一个元素
        return prev;

    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val){ this.val = val; }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

}



