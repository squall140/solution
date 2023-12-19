package org.ex.leetcode.linkedlist.removenthnodefromendoflist019;

import java.util.List;

/**
 * @desc: Remove Nth Node From End of List
 *
 *
 * 暴力解法
 *
 * 一种容易想到的方法是，我们首先从头节点开始对链表进行一次遍历，得到链表的长度 L。
 * 随后我们再从头节点开始对链表进行一次遍历，当遍历到第 L - n + 1 个节点时，它就是我们需要删除的节点。
 *
 * 为了与题目中的 nnn 保持一致，节点的编号从 1 开始，头节点为编号 1 的节点。
 *
 * 为了方便删除操作，我们可以从哑节点(Dummy)开始遍历 L−n+1 个节点
 * 当遍历到第 L−n+1 个节点时，它的下一个节点就是我们需要删除的节点，
 * 这样我们只需要修改一次指针，就能完成删除操作。
 *
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/450350/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2023/12/19 16:00
 */
public class Solution02 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        dummy.next = head;
        ListNode cur = dummy;
        int length = getLength(head);
        // 注意这里的 length-n+1 是怎么来的
        for(int i = 1; i < length - n + 1; i++ ){
            cur = cur.next;
        }
        // 移除相关节点
        cur.next = cur.next.next;
        return dummy.next;
    }


    /**
     * 计算链表长度
     * @param head
     * @return
     */
    public int getLength(ListNode head){
        int length = 0;
        while (head != null){
            ++length;
            head = head.next;
        }
        return length;
    }


}
