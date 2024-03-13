package org.ex.leetcode.linkedlist.reserselinkedlistii092;

import org.ex.leetcode.linkedlist.reverselist206.Ex01;

import java.util.Scanner;

/**
 * @desc:
 *
 * // TODO：需重新review
 *
 * @author: Leif
 * @date: 2024/3/13 11:08
 */
public class Solution02 {
    public static void main(String[] args) {
        ListNode head = creatList();
        printList(head.next);
        int left = 2, right = 4;
        ListNode list = reverseBetween(head.next, left, right);
        printList(list);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 前进到左端点
        for (int i = 0 ; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        // 开始反转左端点到下一个节点到 right - left 个节点
        pre.next = reverseLinkedList(cur, right - left);
        return dummy.next;
    }

    public static ListNode reverseLinkedList(ListNode head, int count) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null && count > 0 ){
            ListNode temp = cur.next;
            // 反向指向
            cur.next = pre;
            // 用当前节点值更新去前驱节点值
            pre = cur;
            // 更新反转后的新节点值
            cur = temp;
            count--;
        }
        return pre;
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
