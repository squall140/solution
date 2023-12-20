package org.ex.leetcode.linkedlist.reverselinkedlistii;

/**
 * @desc: Reverse LinkedList II
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * Example1:
 *
 * <img src = "https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" />
 *
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * </p>
 *
 * 思路一、迭代法
 * 看动画
 * https://leetcode.cn/problems/reverse-linked-list/solutions/2361282/206-fan-zhuan-lian-biao-shuang-zhi-zhen-r1jel/
 * <img src ="https://pic.leetcode-cn.com/1604779288-jExDGV-Picture3.png" />
 *
 * @author: Leif
 * @date: 2023/12/20 13:35
 */
public class Solution {

    //TODO: 12.20 15:00 脑子有点儿无法集中，明儿再看
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy, pre = dummy;

        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);


        return dummy.next;
    }


    /**
     * 迭代法反转
     * @param head
     */
    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            // 找出当起节点cur的后继节点
            ListNode tmp = cur.next;
            // 修改当前节点 next 引用指向
            cur.next = pre;
            // 更新pre，pre 暂存 cur
            pre = cur;
            // 更新cur，访问下一节点
            cur = tmp;
        }

    }


}
