package org.ex.leetcode.top100.linkedlist.mergetwosortedlists021;


/**
 * @desc: Merge Two Sorted Lists
 *
 * 迭代法，比较容易理解
 *
 * @author: Leif
 * @date: 2024/4/2 09:47
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 尾部处理(可能有一个链表没有遍历到尾部）
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;

    }

}
