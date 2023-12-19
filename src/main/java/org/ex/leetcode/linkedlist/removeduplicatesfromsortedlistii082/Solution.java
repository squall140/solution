package org.ex.leetcode.linkedlist.removeduplicatesfromsortedlistii082;

/**
 * @desc: Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * <img src= "https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" />
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/19 22:01
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        // 保证遍历时候有2个节点
        while (cur.next != null && cur.next.next !=null ){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                // 如果当前 cur.next 与 cur.next.next 对应的元素相同，
                // 那么我们就需要将 cur.next 以及所有后面拥有相同元素值的链表节点全部删除。
                // 我们记下这个元素值 xxx，随后不断将 cur.next 从链表中移除，
                // 直到 cur.next 为空节点或者其元素值不等于 xxx 为止
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
