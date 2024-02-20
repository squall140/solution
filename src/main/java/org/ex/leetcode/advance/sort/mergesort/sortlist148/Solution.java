package org.ex.leetcode.advance.sort.mergesort.sortlist148;

/**
 * @desc: Sort List
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * 思路 归并算法
 *
 * 题目要求
 * time complexity O(logn)
 * space complexity O(1)
 *
 * @author: Leif
 * @date: 2024/2/20 09:07
 */
public class Solution {
    public static ListNode sortList(ListNode head) {
        // 1. 递归结束条件
        if(head == null || head.next == null) return head;
        // 2. 找到链表的中间节点截开，递归下探
        ListNode midNode = findMidNode(head);
        // 下段链表的head
        ListNode midRightNode = midNode.next;
        // 3. 断开链表
        midNode.next = null;
        // 4. 分别递归对两段链表进行拆分
        ListNode left = sortList(head);
        ListNode right = sortList(midRightNode);
        // 5. 合并+排序
        return mergeSortTwoListNode(left, right);
    }

    /**
     * 合并两个有序链表（21. 合并两个有序链表）
     * @param l1
     * @param l2
     * @return ListNode
     */
    private static ListNode mergeSortTwoListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 对比排序（从小到大）
        while(l1 != null && l2 != null ){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 处理尾部
        if ( l1 != null ){
            cur.next = l1;
        }else{
            cur.next = l2;
        }
        return dummy.next;

    }

    /**
     * 找到链表中间节点（876. 链表的中间结点）
     * @param head
     * @return ListNode
     */
    private static ListNode findMidNode(ListNode head){
        if(head == null || head.next == null) return head;
        // 双指针法，快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        // 注意：这里中点mid需要偏左所以fast初始化要先走一步，如果是876原题直接快慢指针都初始化为head就行
        // 因为下一截要从mid的right开始
        fast = fast.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            //快指针走2步
            fast = fast.next.next;

        }
        // 拿到中心点
        return slow;

    }

    public static void main(String[] args) {
        // head = [-1,5,3,4,0]
        // 创建首节点
        ListNode head = new ListNode(-1);

        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(0);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("before ================");
        print(head);

        // 归并排序
        sortList(head);
        System.out.println("after ================");
        print(head);
    }

    static void print(ListNode ln){
        //创建链表节点
        while(ln!=null){
            System.out.println("ListNode:"+ln.val);
            ln=ln.next;
        }
        System.out.println();
    }


}
