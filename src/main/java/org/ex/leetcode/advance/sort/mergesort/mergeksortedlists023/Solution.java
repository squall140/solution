package org.ex.leetcode.advance.sort.mergesort.mergeksortedlists023;

/**
 * @desc: Merge K Sorted Lists
 * You are given an array of k linked-lists lists,
 * each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 * 思路 归并排序（小顶堆的解法也有，自己找一下）
 *
 * @author: Leif
 * @date: 2024/2/20 13:11
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode listNode : lists){
            ans = mergeTwoLists(ans, listNode);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while ( l1 != null && l2 != null){
            if (l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;
        return head.next;

    }


}
