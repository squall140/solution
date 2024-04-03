package org.ex.leetcode.top100.linkedlist.mergeksortedlists023;

/**
 * @desc: Merge K Sorted Lists
 *
 * 思路， 递归法比较简单
 * @author: Leif
 * @date: 2024/4/3 14:29
 */
public class Solution01 {
    public ListNode mergerKLists(ListNode[] lists){
        ListNode ans = null;
        for(ListNode list : lists){
            ans = mergeTwoLists(ans,list);
        }
        return ans;

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // 终止条件
        if (l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        // 遍历双链表，从小到达合并到tail
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next =  l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 链表尾部追加
        tail.next = l1 != null ? l1 : l2;
        return head.next;
    }

}
