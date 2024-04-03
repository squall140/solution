package org.ex.leetcode.top100.linkedlist.palindromelinkedlist234;

/**
 * @desc: Palindrome LinkedList
 * @author: Leif
 * @date: 2024/4/2 08:46
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        // 快指针走到链表尾，慢指针恰好在中间
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 快指针重新指向队首
        fast = head;
        // 慢指针作为首节点，准备反转后半部分链表
        slow = reverse(slow);

        // 后半部分翻转后，开始对比前半部分、后半部分是否完全一致，如果完全一致就成镜面回文
        while(slow != null && slow.val == fast.val){
            slow = slow.next;
            fast = fast.next;
        }
        // 当slow == fast当条件全部走完了，链表完全遍历完了，slow == null当时候返回true
        return slow == null ? true : false;

    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null , cur = head;
        while ( cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


}
