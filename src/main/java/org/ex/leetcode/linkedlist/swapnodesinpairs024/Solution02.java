package org.ex.leetcode.linkedlist.swapnodesinpairs024;

/**
 * @desc: 两两交换链表节点
 *
 * 思路一，简单理解版本
 *
 * @author: Leif
 * @date: 2023/12/18 15:59
 */
public class Solution02 {
    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode one = head;
        ListNode two = head.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs(three);

        return two;
    }

    public static void printNode(ListNode node){
        while (node != null){
            System.out.println("node: " + node.val);
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 创建首节点
        ListNode head = new ListNode(0);
        // 声明下一个节点
        ListNode next;
        // 指向首节点
        next = head;

        for (int i=1; i<5; i++){
            ListNode node = new ListNode(i);
            next.next = node;
            next = next.next;
        }

        next = head;
        printNode(next);

    }



}
