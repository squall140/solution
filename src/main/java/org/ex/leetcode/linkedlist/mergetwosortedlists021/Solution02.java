package org.ex.leetcode.linkedlist.mergetwosortedlists021;

/**
 * @desc: Merge Two Sorted Lists
 *  *
 *  * You are given the heads of two sorted linked lists list1 and list2.
 *  * Merge the two lists into one sorted list.
 *  * The list should be made by splicing together the nodes of the first two lists.
 *  * Return the head of the merged linked list.
 *
 *  思路二 递归法
 *
 *  O(m+n): 时间复杂度和双指针的迭代一样，都要遍历两个链表，所以跟链表长度有关系
 *  O(m+n): 递归法中，由于每次遍历，都要产生不同的新变量，那么递归多少次（产生多少内存变量），也取决于两个链表的长度。
 *
 *  参考
 *  https://leetcode.cn/problems/merge-two-sorted-lists/solutions/103891/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
 *
 * @author: Leif
 * @date: 2023/12/20 10:29
 */
public class Solution02 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // 边界条件
        if (l1 ==null) return l2;
        if (l2 ==null) return l1;

        // 只比较两个链表第一个元素
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2);
            return l2;
        }

    }


}
