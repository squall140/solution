package org.ex.leetcode.top100.linkedlist.sortlist148;

/**
 * @desc: Sort List
 *
 * 思路，归并排序
 * 因为题目中要求了时间复杂度  O(nlogn)
 * @author: Leif
 * @date: 2024/4/3 15:03
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // 1. 递归结束条件
        if ( head == null || head.next == null) return head;
        // 2. 确定中心分割点，递归下探，把链表分成两段
        ListNode midNode = findMidNode(head);
        ListNode rightMidNode = midNode.next;
        // 3. 截断链表
        midNode.next = null;
        // 4. 分成两个子链表 分别进行递归
        ListNode left = sortList(head);
        ListNode right = sortList(rightMidNode);
        // 5. 合并+排序
        return mergetTwoList(left, right);
    }

    /**
     * 合并 + 排序
     * 从小到大
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergetTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l1 : l2;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 队尾判断
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;

    }

    /**
     * 切分链表两段，快慢指针法
     * @param head
     * @return
     */
    private ListNode findMidNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
