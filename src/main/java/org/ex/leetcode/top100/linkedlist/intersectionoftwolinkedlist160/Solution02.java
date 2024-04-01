package org.ex.leetcode.top100.linkedlist.intersectionoftwolinkedlist160;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/1 21:43
 */
public class Solution02 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = headA;
        // iterated add visited list node to set
        while(tmp != null){
            visited.add(tmp);
            tmp = tmp.next;
        }

        // if headA's node contains headB
        tmp = headB;
        while(tmp != null){
            if(visited.contains(tmp)) return tmp;
            tmp = tmp.next;
        }
        return null;

    }

    public static void main(String[] args) {

    }
}
