package org.ex.leetcode.linkedlist.mergetwosortedlists021;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/12 14:36
 */
public class Ex01 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while ( list1 != null && list2 != null){
            // 由小到大
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;

        }
        //尾部最后一个元素判断
        cur.next = list1.next != null ? list1 : list2;
        return dummy.next;

    }
}
