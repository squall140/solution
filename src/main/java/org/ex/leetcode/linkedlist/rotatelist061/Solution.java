package org.ex.leetcode.linkedlist.rotatelist061;

import java.util.List;

/**
 * @desc: Rotate List
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places. <Br />
 * <img src= "https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" />
 * <p>
 * Example1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * </p>
 * <p>
 * 思路
 * 环形链表 断开位置， k可能无限大，所以要和n取模后再相减
 * @author: Leif
 * @date: 2024/1/30 09:09
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        // 节点计数
        int n = 1;
        // 1. 第一次遍历，抵达链表尾部
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        // 2. 头尾相连，形成环
        cur.next = head;

        // 3. 第二次遍历，抵达第 n - (k % n) 个节点，也就是即将断开的节点位置
        for (int i = 0; i < n - (k % n); i++) {
            cur = cur.next;
        }

        // 4. 更新头节点，断开链表
        head = cur.next;
        cur.next = null;

        return head;


    }

}
