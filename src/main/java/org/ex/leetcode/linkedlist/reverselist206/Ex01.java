package org.ex.leetcode.linkedlist.reverselist206;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/13 09:52
 */
public class Ex01 {
    public ListNode reserveList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null){
            // 暂存当前节点的下一个指针节点
            ListNode temp = cur.next;
            // 当前节点反向指向前驱节点
            cur.next = pre;
            // 更新前驱节点
            pre = cur;
            // 用暂存节点更新新节点
            cur = temp;

        }
        // 此时pre成为了head
        return pre;

    }





    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

    }
}
