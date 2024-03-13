package org.ex.leetcode.linkedlist.oddevenlinkedlist328;

import java.util.Scanner;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/13 10:31
 */
public class Ex01 {
    public static void main(String[] args) {
        ListNode head = creatList();
        printList(head.next);
        ListNode list = oddEvenList(head.next);
        printList(list);
    }

    private static ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode J = head;
        ListNode O = head.next;
        // 保存偶链头节点
        ListNode oHead = O ;

        while ( O != null && O.next != null){
            // 奇 连 奇 （O.next节点实际就是奇节点）
            J.next = O.next;
            // 推进奇数链表
            J = J.next;
            // 偶 连 偶 （J.next节点实际就是偶节点）
            O.next = J.next;
            // 推进偶数链表
            O = O.next;
        }

        // 奇链连上偶链
        J.next = oHead;
        return head;
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
