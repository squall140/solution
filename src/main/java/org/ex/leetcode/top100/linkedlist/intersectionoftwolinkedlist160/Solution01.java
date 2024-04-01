package org.ex.leetcode.top100.linkedlist.intersectionoftwolinkedlist160;

/**
 * @desc: Intersection of two linkedlist
 *
 * @author: Leif
 * @date: 2024/4/1 21:09
 */
public class Solution01 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = 0, c2 = 0;
        ListNode tmpA = headA, tmpB = headB;
        while(tmpA != null && ++c1 > 0) tmpA = tmpA.next;
        while(tmpB != null && ++c2 > 0) tmpB = tmpB.next;
        // find the count difference between headA and headB.
        int x = Math.abs(c1 - c2);
        // iterate from the variable x, diminishing
        while ( x-- > 0){
            if (c1 > c2){
                headA = headA.next;
            }else{
                headB = headB.next;
            }
        }
        // continue to iterate two linked list util find the specific intersection
        while ( headA != null && headB != null){
            if(headA.equals(headB)){
                // if the value of headA can equal with headB, return headA as the result
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
