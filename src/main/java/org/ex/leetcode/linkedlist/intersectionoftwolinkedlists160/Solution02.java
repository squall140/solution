package org.ex.leetcode.linkedlist.intersectionoftwolinkedlists160;

/**
 * @desc:  Intersection of Two Linked Lists
 *
 *
 * 思路二，差值解法
 *
 * 先对两条链表扫描一遍，取得两者长度，然后让长的链表先走「两者的长度差值」，
 * 然后再同时走，遇到第一个节点即是答案。
 *
 * 时间复杂度：O(n+m)
 * 空间复杂度：O(1)
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/20 15:39
 */
public class Solution02 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = 0, c2 = 0;
        ListNode tmpA = headA, tmpB = headB;
        // 开始计算两个链表长度
        while(tmpA != null && ++c1 > 0 ) tmpA = tmpA.next;
        while(tmpB != null && ++c2 > 0) tmpB = tmpB.next;
        // 得到差值
        int x = Math.abs(c1 - c2);
        // 较长的链表先走到 x 的位置
        while (x-- > 0){
            if (c1 > c2)
                headA = headA.next;
            else
                headB = headB.next;
        }

        // 较长从x的位置开始起步意味着两个链表在在相同位置开跑，遍历两个链表，取出相等值，或者返回null
        while (headA != null && headB != null){
            if (headA.equals(headB)){
                //找到相等元素后直接返回链表头
                return headA;
            }else{
                //继续向后迭代
                headA = headA.next;
                headB = headB.next;
            }
        }
        //实在找不到就返回null,证明不相交
        return null;

    }



}
