package org.ex.leetcode.top100.linkedlist.removenthfromendoflist019;

import java.util.List;

/**
 * @desc: Remove Nth Node From end of List
 * 双指针 跑表，注重技巧
 * @author: Leif
 * @date: 2024/4/2 10:19
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 固定写法
        ListNode dummy = new ListNode(-1,head);
        // 双指针
        ListNode start = dummy, end = dummy;

        // start先跑到n
        while ( n-- > 0){
            start = start.next;
        }

        // end 和 start一起跑，start跑到末尾的时候，end就是n的位置
        while(start.next != null){
            start = start.next;
            end = end.next;
        }

        end.next = end.next.next;
        // 返回首节点
        return dummy.next;

    }
}
