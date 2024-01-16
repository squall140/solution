package org.ex.leetcode.linkedlist.mergedksortedlists023;

import java.util.*;

/**
 * @desc: Merge K Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * <p>
 * Example 2:
 * Input: lists = []
 * Output: []
 * <p>
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 * <p>
 * <p>
 * 思路一 暴力法
 * 1. 把给到的链表数组遍历，取出所有链表中的元素，存入一个新的数组中
 * 2. 对数组进行升序排序
 * 3. 再次遍历数组，形成链表（升序）
 *
 * 思路二 小顶堆法（当前代码方案）
 *
 *
 * @author: Leif
 * @date: 2024/1/16 14:54
 */
public class Solution01 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 创建小顶堆
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2)-> v1.val - v2.val) ;
        // 将链表数组中的所有子链表入小顶堆（头节点小的子链表顺序入堆）
        for(ListNode node:lists){
            if(node != null){
                pq.offer(node);
            }
        }

        // 创建新的空链表
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 依次进行小顶堆入堆出堆操作，当小顶堆没有元素了算法结束
        while(!pq.isEmpty()){
            // 当前最小的头节点出堆
            ListNode minNode = pq.poll();
            // 新的链表当前节点指向minNode
            cur.next = minNode;
            // cur往前走一步
            cur = cur.next;
            // 将新链表中minNode的下一个节点入堆
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }

}
