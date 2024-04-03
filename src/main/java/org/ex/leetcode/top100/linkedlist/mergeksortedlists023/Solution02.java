package org.ex.leetcode.top100.linkedlist.mergeksortedlists023;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc:
 * 思路 小顶堆
 * @author: Leif
 * @date: 2024/4/3 14:45
 */
public class Solution02 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 小顶堆
        Queue<ListNode> pq = new PriorityQueue<>( (o1, o2) -> o1.val - o2.val);
        // 将每个链表头节点放入小顶堆
        for(ListNode list : lists){
            pq.offer(list);
        }

        // 创建新的空链表
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(!pq.isEmpty()){
            // 剩余堆中最小节点出堆
            ListNode curMinNode = pq.poll();
            // 当前最小节点加入新链表
            cur.next = curMinNode;
            cur = cur.next;
            // 下一个节点如果不为空
            if (curMinNode.next != null){
                // 那么下一个节点有可能是最小节点，重新入堆
                pq.offer(curMinNode.next);
            }

        }

        return dummy.next;

    }
}
