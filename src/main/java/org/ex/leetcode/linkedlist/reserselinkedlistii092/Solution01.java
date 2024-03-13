package org.ex.leetcode.linkedlist.reserselinkedlistii092;

import java.util.Scanner;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/13 11:08
 */
public class Solution01 {
    public static void main(String[] args) {
        ListNode head = creatList();
        printList(head.next);
        int left = 2, right = 4;
        ListNode list = reverseBetween(head.next, left, right);
        printList(list);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;

    }

    public static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        pre = cur;
        while (cur != null){
            ListNode temp = cur.next;
            // 反向指向
            cur.next = pre;
            // 用当前节点值更新去前驱节点值
            pre = cur;
            // 更新反转后的新节点值
            cur = temp;
        }
    }

    private static void printList(ListNode head) {
        while ( head != null ){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode creatList() {
        Scanner scanner = new Scanner(System.in);
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            if (num == -1) break;
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = cur.next;
        }
        return pre;
    }
}
