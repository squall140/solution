package org.ex.leetcode.top100.linkedlist.swapnodesinpairs024;

/**
 * @desc: Swap Nodes In Pairs
 *
 * 思路 递归
 *
 * 思考3个条件
 * 1.返回值：交换完成的子链表
 * 2.调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
 * 3.终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
 *
 * 作者：画手大鹏
 * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/7058/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/4/3 15:26
 */
public class Solution01 {
    public ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 后续需要交换的子链表
        ListNode rest = head.next.next;
        // newHead 就是head.next
        ListNode newHead = head.next;
        // 用 newHead 反向连接 head
        newHead.next = head;
        // 用 head 连接后续需要交换的子链表，进行递归
        head.next = swapPairs(rest);

        // 返回当前头节点
        return newHead;
    }

}
