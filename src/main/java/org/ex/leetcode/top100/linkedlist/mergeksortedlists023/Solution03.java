package org.ex.leetcode.top100.linkedlist.mergeksortedlists023;

/**
 * @desc: review recursion
 *
 * @author: Leif
 * @date: 2024/5/11 10:45
 */
public class Solution03 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(ListNode list : lists){
            ans = mergeTwoLists(ans, list);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
