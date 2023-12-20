package org.ex.leetcode.linkedlist.mergetwosortedlists021;

/**
 * @desc: Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * <br />
 * Example1:
 * <br />
 * <img src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" />
 * <br />
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 *
 * 思路，暴力解法 双指针 迭代法
 * O(m+n): M,N 分别为链表 list1 和 list2 的长度，合并操作需遍历两链表。
 * O(1): 节点引用 dummy , cur 使用常数大小的额外空间。
 *
 * 看动画
 * https://leetcode.cn/problems/merge-two-sorted-lists/solutions/2361535/21-he-bing-liang-ge-you-xu-lian-biao-shu-aisw/
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/20 09:43
 */
public class Solution01 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while ( list1 !=null && list2 !=null ){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // 合并剩余尾部：循环结束时考虑到有两种情况，即 l1 为空或者 l2 为空
        // 需要追加不为空的元素
        cur.next = list1 != null ? list1 : list2;

        return dummy.next;

    }


}


