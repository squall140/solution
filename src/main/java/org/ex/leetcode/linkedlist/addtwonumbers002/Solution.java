package org.ex.leetcode.linkedlist.addtwonumbers002;

import java.util.List;
import java.util.Stack;

/**
 * @desc: Add Two Numbers
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * <img src = "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" />
 *
 * <p>
 *      输入：l1 = [2,4,3], l2 = [5,6,4]
 *      输出：[7,0,8]
 *      解释：342 + 465 = 807.
 *
 * </p>
 *
 *
 * 思路
 *
 *
 * 迭代的思路是，初始化答案为一个「空链表」，每次循环，向该链表末尾添加一个节点（保存一个数位）。
 *
 * 循环即遍历链表 l1 , l2, 每次把两个节点值 l1.val , l2.val 与进位值 carry相加，然后除以10，
 * 余数作为当前节点需要保存的数位，商为新的进位值（ 12 / 10 = 商 1 余 2，那么 1 就是新的节点值，2就是当前节点值）
 *
 * 作者：灵茶山艾府
 * 链接：https://leetcode.cn/problems/add-two-numbers/solutions/2327008/dong-hua-jian-ji-xie-fa-cong-di-gui-dao-oe0di/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2023/12/21 13:28
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);  //哨兵
        ListNode cur = dummy;

        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0){
            if (l1 != null) carry += l1.val; // 节点值和进位值相加
            if (l2 != null) carry += l2.val;  // 节点值和进位值相加
            cur.next = new ListNode(carry % 10); // 每个节点保存一个数位
            cur = cur.next;
            // 新增的进位
            carry = carry / 10;

            if (l1 != null) l1 = l1.next; // l1前进一个节点
            if (l2 != null) l2 = l2.next; // l2前进
        }

        return dummy.next; // 哨兵节点的下一个节点就是头节点

    }



}
